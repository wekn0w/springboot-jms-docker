package web.service;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import web.amqp.RequestMessageSender;
import web.amqp.SaveMessageSender;
import web.domain.MessageRecord;
import web.dto.CommentMessage;
import web.dto.MessageDto;
import web.dto.ReviewDto;
import web.repo.MessageRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final MessageRepo messageRepository;

    private final RequestMessageSender requestMessageSender;

    private final SaveMessageSender saveMessageSender;


    public ReviewServiceImpl(MessageRepo messageRepository, RequestMessageSender requestMessageSender, SaveMessageSender saveMessageSender) {
        this.messageRepository = messageRepository;
        this.requestMessageSender = requestMessageSender;
        this.saveMessageSender = saveMessageSender;
    }

    @Override
    public List<ReviewDto> getByBook(String name) {
        List<ReviewDto> result = new ArrayList<>();
        MessageDto reviewResponse = null;
        if (name != null && !name.isEmpty()) {
            reviewResponse = getReviewResponse(name);
        }
        if (reviewResponse != null) {
            List<String> reviews = Arrays.asList(reviewResponse.getMessage().split("\\s*&&\\s*"));
            reviews.forEach(i -> result.add(new ReviewDto(null, i, name)));
        }
        return result;
    }

    @Override
    public void save(ReviewDto dto) {
        saveMessageSender.sendMessage(new CommentMessage(dto.getId(), dto.getComment(), dto.getBook()));
    }

    @Nullable
    private MessageDto getReviewResponse(String name) {
        MessageDto reviewResponse = null;
        UUID key = UUID.randomUUID();
        MessageDto reviewRequest = new MessageDto(name, key);
        requestMessageSender.sendMessage(reviewRequest);
        int count = 0;
        try {
            while (count != 5 && reviewResponse == null) {
                Thread.sleep(1000);
                MessageRecord record = messageRepository.findOneByUuid(key);
                if (record != null)
                    reviewResponse = new MessageDto(record.getMessage(), record.getUuid());
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return reviewResponse;
    }

}

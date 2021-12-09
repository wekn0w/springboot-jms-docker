package web.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import web.dto.MessageDto;
import web.dto.ReviewDto;
import web.repo.MessageRepo;
import web.service.ReviewService;
import web.utils.MQConsts;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookRequestMessageListenerImpl implements MessageListener {

    private final ReviewService reviewService;
    private final MessageSender messageSender;

    public BookRequestMessageListenerImpl(final MessageRepo messageRepository, final ReviewService reviewService, final MessageSender messageSender) {
        this.reviewService = reviewService;
        this.messageSender = messageSender;
    }

    @Override
    @RabbitListener(queues = MQConsts.QUEUE_BOOK_ASK_REVIEWS)
    public void consumeMessage(MessageDto message) {
        String bookName = message.getMessage();
        List<ReviewDto> reviews = reviewService.findByName(bookName);
        if (reviews != null)
            messageSender.sendMessage(new MessageDto(reviews.stream().map(ReviewDto::getComment).collect(Collectors.joining("&&")), message.getKey()));
    }
}

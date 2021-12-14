package web.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import web.domain.MessageRecord;
import web.dto.CommentMessage;
import web.dto.ReviewDto;
import web.repo.MessageRepo;
import web.service.ReviewService;
import web.utils.MQConsts;

@Service
public class ReviewSaveMessageListenerImpl implements ReviewSaveMessageListener {

    private final MessageRepo messageRepository;
    private final ReviewService reviewService;

    public ReviewSaveMessageListenerImpl(MessageRepo messageRepository, ReviewService reviewService) {
        this.messageRepository = messageRepository;
        this.reviewService = reviewService;
    }

    @Override
    @RabbitListener(queues = MQConsts.QUEUE_BOOK_SAVE_REVIEW)
    public void consumeMessage(CommentMessage message) {
        messageRepository.save(new MessageRecord(message.getId(), message.getComment(), message.getBook(), message.getKey()));
        reviewService.save(new ReviewDto(message.getId(), message.getComment(), message.getBook()));
    }
}

package web.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import web.dto.CommentMessage;
import web.utils.MQConsts;

@Service("asynch")
public class ReviewUpdateMessageSenderImpl implements SaveMessageSender {

    private final RabbitTemplate rabbitTemplate;

    public ReviewUpdateMessageSenderImpl(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(CommentMessage commentMessage) {
        rabbitTemplate.convertAndSend(MQConsts.QUEUE_BOOK_SAVE_REVIEW, commentMessage);
    }
}

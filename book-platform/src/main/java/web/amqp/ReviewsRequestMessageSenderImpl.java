package web.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import web.dto.MessageDto;
import web.utils.MQConsts;

@Service("synch")
public class ReviewsRequestMessageSenderImpl implements RequestMessageSender {

    private final RabbitTemplate rabbitTemplate;

    public ReviewsRequestMessageSenderImpl(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(MessageDto str) {
        rabbitTemplate.convertAndSend(MQConsts.QUEUE_BOOK_ASK_REVIEWS, str);
    }
}

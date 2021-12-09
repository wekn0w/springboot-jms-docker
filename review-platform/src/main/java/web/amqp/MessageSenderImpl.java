package web.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import web.dto.MessageDto;
import web.utils.MQConsts;

@Service
public class MessageSenderImpl implements MessageSender {

    private final RabbitTemplate rabbitTemplate;

    public MessageSenderImpl(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(MessageDto str) {
        rabbitTemplate.convertAndSend(MQConsts.QUEUE_REVIEW_SEND_REVIEWS, str);
    }
}

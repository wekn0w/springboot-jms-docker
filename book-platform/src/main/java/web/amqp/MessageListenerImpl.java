package web.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import web.domain.MessageRecord;
import web.dto.MessageDto;
import web.repo.MessageRepo;
import web.utils.MQConsts;

@Service
public class MessageListenerImpl implements MessageListener {

    private final MessageRepo messageRepository;

    public MessageListenerImpl(MessageRepo messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    @RabbitListener(queues = MQConsts.QUEUE_REVIEW_SEND_REVIEWS)
    public void consumeMessage(MessageDto message) {
        messageRepository.save(new MessageRecord(message.getMessage(), message.getKey()));
    }
}

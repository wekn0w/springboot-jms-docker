package web.amqp;

import org.springframework.stereotype.Service;
import web.dto.MessageDto;

@Service
public interface MessageListener {

    void consumeMessage(final MessageDto message);
}

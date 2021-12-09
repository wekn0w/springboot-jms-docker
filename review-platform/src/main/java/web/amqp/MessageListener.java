package web.amqp;

import web.dto.MessageDto;

public interface MessageListener {

    void consumeMessage(final MessageDto message);
}

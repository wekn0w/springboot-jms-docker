package web.amqp;

import web.dto.MessageDto;

public interface MessageSender {
    void sendMessage(MessageDto str);
}

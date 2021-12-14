package web.amqp;

import web.dto.MessageDto;

public interface RequestMessageSender {
    void sendMessage(MessageDto str);
}

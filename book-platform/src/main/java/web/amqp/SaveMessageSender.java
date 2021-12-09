package web.amqp;

import web.dto.CommentMessage;

public interface SaveMessageSender {
    void sendMessage(CommentMessage commentMessage);
}

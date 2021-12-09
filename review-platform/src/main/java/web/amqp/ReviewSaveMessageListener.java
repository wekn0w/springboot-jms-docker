package web.amqp;

import web.dto.CommentMessage;

public interface ReviewSaveMessageListener {

    void consumeMessage(final CommentMessage message);
}

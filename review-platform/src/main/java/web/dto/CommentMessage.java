package web.dto;

import java.util.UUID;

public class CommentMessage {
    private Long id;
    private String comment;
    private String book;
    private UUID key;

    public CommentMessage() {
    }

    public CommentMessage(Long id, String comment, String book, UUID key) {
        this.id = id;
        this.comment = comment;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }
}

package web.dto;

public class CommentMessage {
    private Long id;
    private String comment;
    private String book;

    public CommentMessage() {
    }

    public CommentMessage(Long id, String comment, String book) {
        this.id = id;
        this.comment = comment;
        this.book = book;
    }
}

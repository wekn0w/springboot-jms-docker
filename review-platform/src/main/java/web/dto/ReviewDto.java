package web.dto;

public class ReviewDto {
    private Long id;
    private String comment;
    private String book;

    public ReviewDto() {
    }

    public ReviewDto(Long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public ReviewDto(Long id, String comment, String book) {
        this.id = id;
        this.comment = comment;
        this.book = book;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}

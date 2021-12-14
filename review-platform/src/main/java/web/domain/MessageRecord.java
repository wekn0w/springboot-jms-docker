package web.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class MessageRecord {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private String book;

    @Column(unique = true)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID uuid;

    public MessageRecord() {
    }

    public MessageRecord(Long id, String message, String book, UUID key) {
        this.id = id;
        this.comment = message;
        this.book = book;
        this.uuid = key;
    }

    public MessageRecord(String message, UUID key) {
        this.comment = message;
        this.uuid = key;
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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}

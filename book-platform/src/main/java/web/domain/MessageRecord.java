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
    private String message;
    @Column(unique = true)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID uuid;

    public MessageRecord() {
    }

    public MessageRecord(Long id, String message, UUID key) {
        this.id = id;
        this.message = message;
        this.uuid = key;
    }

    public MessageRecord(String message, UUID key) {
        this.message = message;
        this.uuid = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}

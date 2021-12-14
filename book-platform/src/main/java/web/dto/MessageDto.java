package web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class MessageDto {
    private String message;
    private UUID key;

    public MessageDto() {
    }

    public MessageDto(@JsonProperty("text") String message, @JsonProperty("key") UUID key) {
        this.message = message;
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }
}

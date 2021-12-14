package web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum Permission {
    RECORD_READ("read"),
    RECORD_WRITE("write");
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private final String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

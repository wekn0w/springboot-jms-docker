package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.domain.MessageRecord;

import java.util.List;
import java.util.UUID;

public interface MessageRepo extends JpaRepository<MessageRecord, Long> {
    List<MessageRecord> findByUuid(UUID key);
}

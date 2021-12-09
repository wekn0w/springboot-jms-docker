package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.domain.MessageRecord;

import java.util.UUID;

public interface MessageRepo extends JpaRepository<MessageRecord, Long> {
    MessageRecord findOneByUuid(UUID key);
}

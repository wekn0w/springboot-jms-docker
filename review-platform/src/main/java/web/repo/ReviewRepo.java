package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.domain.Review;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {
    List<Review> findByBookName(String bookName);
}

package web.service;

import org.springframework.stereotype.Service;
import web.domain.Review;
import web.dto.ReviewDto;
import web.repo.ReviewRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepository;

    public ReviewServiceImpl(ReviewRepo reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewDto> findAll() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDto> resultList = new ArrayList<>();
        reviews.forEach(i -> resultList.add(new ReviewDto(i.getId(), i.getComment(), i.getBookName())));
        return resultList;
    }

    @Override
    public ReviewDto getOneById(Long id) {
        Review stored = reviewRepository.findById(id).orElse(new Review());
        return new ReviewDto(stored.getId(), stored.getComment(), stored.getBookName());
    }

    @Transactional
    @Override
    public ReviewDto save(ReviewDto review) {
        Review newReview = reviewRepository.findById(review.getId()).orElse(new Review());
        if (review.getComment() != null && !review.getComment().isEmpty()) {
            newReview.setComment(review.getComment());
        }
        if (review.getBook() != null) {
            newReview.setBookName(review.getBook());
        }
        Review saved = reviewRepository.save(newReview);
        return new ReviewDto(saved.getId(), saved.getComment(), saved.getBookName());
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewDto> findByName(String bookName) {
        List<Review> reviews = reviewRepository.findByBookName(bookName);
        List<ReviewDto> result = null;
        if (reviews != null && !reviews.isEmpty()) {
            result = new ArrayList<>();
            List<ReviewDto> finalResult = result;
            reviews.forEach(i -> finalResult.add(new ReviewDto(i.getId(), i.getComment(), i.getBookName())));
        }
        return result;
    }

}

package web.service;

import web.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    ReviewDto getOneById(Long id);

    ReviewDto save(ReviewDto person);

    void deleteById(Long id);

    List<ReviewDto> findByName(String bookName);
}

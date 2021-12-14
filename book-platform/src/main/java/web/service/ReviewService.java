package web.service;

import web.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getByBook(String name);

    void save(ReviewDto dto);
}

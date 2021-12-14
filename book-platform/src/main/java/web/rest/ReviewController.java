package web.rest;

import org.springframework.web.bind.annotation.*;
import web.dto.ReviewDto;
import web.service.ReviewService;

import java.util.List;

@RestController
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/review/{book}")
    public List<ReviewDto> getByBook(@PathVariable("book") String name) {
        return service.getByBook(name);
    }

    @PostMapping("/review/")
    public void create(@RequestBody ReviewDto dto) {
        service.save(dto);
    }
}

package web.utils;

import org.springframework.stereotype.Component;
import web.domain.Book;
import web.dto.AuthorDto;
import web.dto.BookDto;
import web.dto.GenreDto;
import web.dto.MessageDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class BookAdapter {

    public BookDto convertToDto(Book saved) {
        if (saved == null)
            return null;
        BookDto dto = new BookDto(saved.getName());
        dto.setId(saved.getId());
        if (saved.getBookGenre() != null)
            dto.setBookGenre(new GenreDto(saved.getBookGenre().getId(), saved.getBookGenre().getName()));
        Set<AuthorDto> authorDtoSet = new HashSet<>();
        if (saved.getAuthors() != null) {
            saved.getAuthors().forEach(i -> authorDtoSet.add(new AuthorDto(i.getId(), i.getFullname(), i.getAge())));
        }
        dto.setBookAuthors(authorDtoSet);
        return dto;
    }

    public BookDto convertToDto(Book saved, MessageDto reviews) {
        if (saved == null)
            return null;
        BookDto dto = new BookDto(saved.getName());
        dto.setId(saved.getId());
        if (saved.getBookGenre() != null)
            dto.setBookGenre(new GenreDto(saved.getBookGenre().getId(), saved.getBookGenre().getName()));
        Set<AuthorDto> authorDtoSet = new HashSet<>();
        if (saved.getAuthors() != null) {
            saved.getAuthors().forEach(i -> authorDtoSet.add(new AuthorDto(i.getId(), i.getFullname(), i.getAge())));
        }
        if (reviews != null) {
            dto.setReviewList(Arrays.asList(reviews.getMessage().split("\\s*&&\\s*")));
        }

        dto.setBookAuthors(authorDtoSet);
        return dto;
    }
}

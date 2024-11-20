package com.webserver.book.service;

import com.webserver.book.dto.BookRequestDto;
import com.webserver.book.dto.BookResponseDto;
import com.webserver.book.entity.BookEntity;
import com.webserver.book.repository.BookEntityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    public final BookEntityRepository bookEntityRepository;

    public Long save(BookRequestDto requestDto) {
        String title = requestDto.getTitle();
        String author = requestDto.getAuthor();
        String isbn = requestDto.getIsbn();
        LocalDate publishedDate = requestDto.getPublishedDate();
        BookEntity bookEntity = new BookEntity(title,author,isbn,publishedDate);
        BookEntity savedEntity = bookEntityRepository.save(bookEntity);
        return savedEntity.getId();
    }

    public BookResponseDto getById(Long id) {
        BookEntity bookEntity = bookEntityRepository.findById(id).orElse(null);
        return new BookResponseDto(bookEntity.getId(),bookEntity.getTitle(),bookEntity.getAuthor(),
                bookEntity.getIsbn(),bookEntity.getPublishedDate());
    }

    public List<BookResponseDto> getAll() {
        List<BookEntity> all = bookEntityRepository.findAll();
        List<BookResponseDto> bookResponseDtoList = new ArrayList<>();
        for (BookEntity bookEntity : all) {
            BookResponseDto bookResponseDto = new BookResponseDto(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor(),
                    bookEntity.getIsbn(), bookEntity.getPublishedDate());
            bookResponseDtoList.add(bookResponseDto);
        }
        return bookResponseDtoList;
    }

    public void update(Long id, BookRequestDto requestDto) {
        BookEntity bookEntity = bookEntityRepository.findById(id).get();
        bookEntity.update(requestDto);
    }

    public void delete(Long id) {
        BookEntity bookEntity = bookEntityRepository.findById(id).get();
        bookEntityRepository.delete(bookEntity);
    }


}
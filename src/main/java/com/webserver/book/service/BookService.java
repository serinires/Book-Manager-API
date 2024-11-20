package com.webserver.book.service;

import com.webserver.book.dto.BookRequestDto;
import com.webserver.book.dto.BookResponseDto;
import com.webserver.book.entity.BookEntity;
import com.webserver.book.repository.BookEntityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        BookEntity bookEntity = new BookEntity(title,author,isbn);
        BookEntity savedEntity = bookEntityRepository.save(bookEntity);
        return savedEntity.getId();
    }

    public BookResponseDto getById(Long id) {
        BookEntity bookEntity = bookEntityRepository.findById(id).orElse(null);
        return new BookResponseDto(bookEntity.getId(),bookEntity.getTitle(),bookEntity.getAuthor(),
                bookEntity.getIsbn(),bookEntity.getPublishedDate().toString());
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

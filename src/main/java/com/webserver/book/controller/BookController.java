package com.webserver.book.controller;

import com.webserver.book.dto.BookRequestDto;
import com.webserver.book.dto.BookResponseDto;
import com.webserver.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BookRequestDto requestDto) {
        Long bookId = bookService.save(requestDto);
        return ResponseEntity.ok(bookId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        BookResponseDto result = bookService.getById(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<BookResponseDto> result = bookService.getAll();
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, BookRequestDto requestDto) {
        bookService.update(id, requestDto);
        return ResponseEntity.ok(requestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}

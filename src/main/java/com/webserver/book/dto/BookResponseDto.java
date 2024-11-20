package com.webserver.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String publishedDate;
}

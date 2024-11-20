package com.webserver.book.dto;

import lombok.Data;

@Data
public class BookRequestDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String publishedDate;
}

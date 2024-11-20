package com.webserver.book.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookRequestDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishedDate;
}



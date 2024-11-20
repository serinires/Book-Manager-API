package com.webserver.book.repository;

import com.webserver.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
}

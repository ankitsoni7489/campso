package com.smartcamp.smartcamp.repo;

import com.smartcamp.smartcamp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}

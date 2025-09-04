package com.archis.spring_bebka.service;

import com.archis.spring_bebka.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book save(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAll();
    Book update(Book book);
    void deleteById(Long id);
}

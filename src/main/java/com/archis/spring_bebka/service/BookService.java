package com.archis.spring_bebka.service;

import com.archis.spring_bebka.model.Book;
import com.archis.spring_bebka.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        if (bookRepository.count() == 0) {
            // Sadece title ve author ile oluşturuyoruz
            bookRepository.save(new Book("Book A", "Author A"));
            bookRepository.save(new Book("Book B", "Author B"));
        }
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


}

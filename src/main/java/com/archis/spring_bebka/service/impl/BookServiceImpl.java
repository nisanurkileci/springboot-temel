package com.archis.spring_bebka.service.impl;

import com.archis.spring_bebka.model.Book;
import com.archis.spring_bebka.repository.BookRepository;
import com.archis.spring_bebka.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional()
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation =  Isolation.READ_COMMITTED,rollbackFor = Exception.class)
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    @Transactional()
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}

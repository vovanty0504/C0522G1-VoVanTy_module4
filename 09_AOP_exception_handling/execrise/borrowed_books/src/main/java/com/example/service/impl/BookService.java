package com.example.service.impl;

import com.example.model.BookLibrary;
import com.example.repository.IBookRepository;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<BookLibrary> findAll( ) {
        return bookRepository.findAll();
    }

    @Override
    public BookLibrary findById(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(BookLibrary bookLibrary) {
        bookRepository.save(bookLibrary);
    }
}

package com.example.service;

import com.example.model.BookLibrary;

import java.util.List;

public interface IBookService {

    List<BookLibrary> findAll();

    BookLibrary findById(int id);

    void save(BookLibrary bookLibrary);
}

package com.example.repository;

import com.example.model.BookLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<BookLibrary, Integer> {

    BookLibrary findById(int id);
}

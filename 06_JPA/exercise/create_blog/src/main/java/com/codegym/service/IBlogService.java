package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void update( Blog blog);

    Blog findById(int id);

    void remove(Blog blog);

    Page<Blog> findByNameContains(String name, Pageable pageable);
}

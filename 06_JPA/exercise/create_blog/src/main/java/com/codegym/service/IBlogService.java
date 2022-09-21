package com.codegym.service;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface IBlogService {

    Page<BlogDto> showList(Pageable pageable);

    Page<BlogDto> findTitle( String name, Pageable pageable);

    void save(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void remove(Blog blog);

//    Page<Blog> findTitle(String name, Pageable pageable);
}

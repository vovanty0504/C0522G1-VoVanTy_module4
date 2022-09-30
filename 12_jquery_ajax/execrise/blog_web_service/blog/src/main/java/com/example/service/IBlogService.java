package com.example.service;


import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    List<Blog> findAllBlog(int id);

    Blog findById(int id);

    Page<Blog> findByName(Pageable pageable  , String name);


}

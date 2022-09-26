package com.example.service;


import com.example.model.Blog;

import java.util.List;

public interface IBlogService {

   List<Blog> findAll();

   List<Blog> findAllBlog(int id);

  Blog findById(int id);

}

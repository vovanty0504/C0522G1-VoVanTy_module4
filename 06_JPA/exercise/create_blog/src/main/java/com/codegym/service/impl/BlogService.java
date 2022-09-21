package com.codegym.service.impl;

import com.codegym.dto.BlogDto;
import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

//    @Override
//    public Page<Blog> findAll(Pageable pageable) {
//        return blogRepository.findAll(pageable);
//    }

    @Override
    public Page<BlogDto> showList(Pageable pageable) {
        return blogRepository.showList(pageable);
    }

    @Override
    public Page<BlogDto> findTitle(String name, Pageable pageable) {
        return blogRepository.findTitle(name,pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.delete(blog);
    }

//    @Override
//    public Page<Blog> findTitle(String name, Pageable pageable) {
//        return blogRepository.findTitle(name, pageable);
//    }
}

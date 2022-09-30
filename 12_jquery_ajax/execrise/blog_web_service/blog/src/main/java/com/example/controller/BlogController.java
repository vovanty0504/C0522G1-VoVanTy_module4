package com.example.controller;


import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> showList(Pageable pageable, @RequestParam(defaultValue = "", required = false) String search) {
        Page<Blog> blogList = blogService.findByName(pageable,search);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }



    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> showListCategory(@PathVariable int id) {
        List<Blog> blogList = blogService.findAllBlog(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> showView(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

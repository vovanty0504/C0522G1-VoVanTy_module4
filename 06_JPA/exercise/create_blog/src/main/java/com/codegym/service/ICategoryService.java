package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;


public interface ICategoryService {

    List<Category> finAll();

    void save(Category category);

    void update( Category category);

    Category findById(int id);

    void remove(Category category);
}

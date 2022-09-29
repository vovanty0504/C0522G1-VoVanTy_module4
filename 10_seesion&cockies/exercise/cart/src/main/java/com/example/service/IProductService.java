package com.example.service;


import com.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> finAll();

    Optional<Product> findById(int id);

    void save(Product product);
}

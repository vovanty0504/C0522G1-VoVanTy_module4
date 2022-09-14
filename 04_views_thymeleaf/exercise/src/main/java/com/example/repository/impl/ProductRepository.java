package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "Banh Trang ", "150000", "Banh Ngon"));
        productMap.put(2, new Product(2, "Bim Bim", "150000", "Banh Ngon"));
        productMap.put(3, new Product(3, "Bang tai heo", "150000", "Banh Ngon"));
        productMap.put(4, new Product(4, "Banh trang", "150000", "Banh Ngon"));
    }


    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            if (entry.getValue().getName().contains(name)) {
                productList.add(entry.getValue());
            }
        }
        return productList;
    }

}

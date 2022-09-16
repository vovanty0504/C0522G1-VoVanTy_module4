package comcodegym.service;

import comcodegym.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    void save(Product product);

    void update( Product product);

    Product findById(int id);

    void remove(Product product);

    List<Product> findByName(String name);
}

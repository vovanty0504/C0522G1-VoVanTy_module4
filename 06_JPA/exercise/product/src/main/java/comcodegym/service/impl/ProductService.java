package comcodegym.service.impl;

import comcodegym.model.Product;
import comcodegym.repository.IProductRepository;
import comcodegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
       productRepository.save(product);
    }

    @Override
    public void update( Product product) {
    productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Product product) {
     productRepository.delete(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByNameContains(name);
    }
}

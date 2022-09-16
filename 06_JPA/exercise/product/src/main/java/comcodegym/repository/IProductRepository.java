package comcodegym.repository;

import comcodegym.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {

     Product findById(int id);

     List<Product> findByNameContains(String name);

}

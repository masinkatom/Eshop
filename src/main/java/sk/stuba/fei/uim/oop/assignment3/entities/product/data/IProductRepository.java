package sk.stuba.fei.uim.oop.assignment3.entities.product.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long>{

    List<Product> findAll();
    
}

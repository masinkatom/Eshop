package sk.stuba.fei.uim.oop.assignment3.entities.product.data;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long>{

    ArrayList<Product> findAll();

    Product getProdById(Long id);
    
    
}

package sk.stuba.fei.uim.oop.assignment3.entities.product.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.entities.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequest;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repo;

    @Override
    public List<Product> getAll(){
        return this.repo.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        return this.repo.save(new Product(request));
    }

    
}

package sk.stuba.fei.uim.oop.assignment3.entities.product.logic;

import java.util.List;

import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequest;

public interface IProductService {

    List<Product> getAll();

    Product create(ProductRequest request);
    
}

package sk.stuba.fei.uim.oop.assignment3.entities.product.logic;

import java.util.List;

import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequestUpdate;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

public interface IProductService {
    // get
    List<Product> getAll();
    Product getById(long idProduct) throws NotFoundException;
    int getAmount(long idProduct) throws NotFoundException;

    // post
    Product create(ProductRequest request);

    // put
    Product update(long idProduct, ProductRequestUpdate request) throws NotFoundException;

    // delete
    void delete(long idProduct) throws NotFoundException;

    
}

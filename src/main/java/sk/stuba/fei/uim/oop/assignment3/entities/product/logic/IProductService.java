package sk.stuba.fei.uim.oop.assignment3.entities.product.logic;

import java.util.ArrayList;

import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductAmount;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequestUpdate;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

public interface IProductService {

    ArrayList<Product> getAll();
    Product getById(long idProduct) throws NotFoundException;
    int getAmount(long idProduct) throws NotFoundException;

    Product create(ProductRequest request);
    int addAmount(long idProduct, ProductAmount requestBody) throws NotFoundException;

    Product update(long idProduct, ProductRequestUpdate request) throws NotFoundException;

    void delete(long idProduct) throws NotFoundException;

    void decreaseAmount(Product product, int amount);
}

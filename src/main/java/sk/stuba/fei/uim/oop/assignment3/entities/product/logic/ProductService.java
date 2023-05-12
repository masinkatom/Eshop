package sk.stuba.fei.uim.oop.assignment3.entities.product.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.entities.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequest;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequestUpdate;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository repo;

    @Override
    public List<Product> getAll(){
        return this.repo.findAll();
    }

    @Override
    public Product getById(long idProduct) throws NotFoundException {
        Product product = this.repo.getProdById(idProduct);
        if (product != null){
            return product;
        }
        throw new NotFoundException();
    }

    @Override
    public int getAmount(long idProduct) throws NotFoundException {
        return this.getById(idProduct).getAmount();
    }

    @Override
    public Product create(ProductRequest request) {
        return this.repo.save(new Product(request));
    }

    @Override
    public Product update(long idProduct, ProductRequestUpdate request) throws NotFoundException {
        Product product = this.getById(idProduct);
        if (request.getName() != null) {
            product.setName(request.getName());
        }
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        return this.repo.save(product);
    }

    @Override
    public void delete(long idProduct) throws NotFoundException {
        this.repo.delete(this.getById(idProduct));
    }

    
}

package sk.stuba.fei.uim.oop.assignment3.entities.product.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.stuba.fei.uim.oop.assignment3.entities.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> products = this.service.getAll().stream().map(ProductResponse::new)
                .collect(Collectors.toList());
        return products;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ProductResponse getProduct(@PathVariable("id") Long idProduct) throws NotFoundException {
        return new ProductResponse(this.service.getById(idProduct));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}/amount")
    public ProductAmount getProductAmount(@PathVariable("id") Long idProduct) throws NotFoundException{
        return new ProductAmount(this.service.getAmount(idProduct));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest requestBody) {
        return new ResponseEntity<>(new ProductResponse(this.service.create(requestBody)), HttpStatus.CREATED);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ProductResponse updateProduct(@PathVariable("id") Long idProduct,
            @RequestBody ProductRequestUpdate requestBody) throws NotFoundException {
        return new ProductResponse(this.service.update(idProduct, requestBody));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") Long idProduct) throws NotFoundException{
        this.service.delete(idProduct);
    }

    

}

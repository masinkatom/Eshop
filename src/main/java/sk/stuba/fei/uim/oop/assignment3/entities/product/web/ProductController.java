package sk.stuba.fei.uim.oop.assignment3.entities.product.web;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @GetMapping
    public ArrayList<Product> getProduct(){
        ArrayList<Product> products = new ArrayList<>();
        
        return products;
    }
    

}

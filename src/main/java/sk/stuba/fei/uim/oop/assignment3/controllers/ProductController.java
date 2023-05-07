package sk.stuba.fei.uim.oop.assignment3.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.stuba.fei.uim.oop.assignment3.entities.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
    
    @GetMapping
    public ArrayList<Product> getProduct(){
        ArrayList<Product> products = new ArrayList<>();
        Product p1 = new Product(1, "iPhone 13 Profesional", "128gb", 1, "pcs", 1300);
        Product p2 = new Product(2, "iPhone 12 Profesional", "64gb", 5, "pcs", 1200);
        Product p3 = new Product(3, "iPhone 11 Profesional", "256gb", 2, "pcs", 1100);
        products.add(p3);
        products.add(p2);
        products.add(p1);
        return products;
    }
    

}

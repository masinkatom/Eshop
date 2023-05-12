package sk.stuba.fei.uim.oop.assignment3.entities.product.web;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {

    private String name;

    private String description;

    private int amount;

    private String unit;

    private double price;

}

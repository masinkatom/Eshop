package sk.stuba.fei.uim.oop.assignment3.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
public class Product {
    @Id
    private long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;   
    
    
}

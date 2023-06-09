package sk.stuba.fei.uim.oop.assignment3.entities.product.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.entities.product.web.ProductRequest;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Integer amount;

    private String unit;

    private Double price;

    public Product(ProductRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.amount = request.getAmount();
        this.unit = request.getUnit();
        this.price = request.getPrice();
    }

}

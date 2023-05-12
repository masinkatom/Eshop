package sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;

    private Integer amount;

    public CartProduct(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

}

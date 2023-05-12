package sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.web;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CartProduct {

    private Long productId;

    private Integer amount;

    public CartProduct(sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct cartProduct) {
        this.productId = cartProduct.getProduct().getId();
        this.amount = cartProduct.getAmount();
    }

}

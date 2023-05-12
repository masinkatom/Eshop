package sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.web;

import java.util.ArrayList;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.web.CartProduct;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.data.ShoppingCart;

@Getter
@Setter
public class ShoppingCartResponse {

    private long id;
    private ArrayList<CartProduct> shoppingList;
    private boolean payed;

    public ShoppingCartResponse(ShoppingCart shoppingCart) {
        this.id = shoppingCart.getId();
        this.payed = shoppingCart.isPayed();
        this.shoppingList = shoppingCart.getShoppingList().stream().map(CartProduct::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}

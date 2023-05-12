package sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.logic;

import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.web.CartProduct;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.data.ShoppingCart;
import sk.stuba.fei.uim.oop.assignment3.exceptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

public interface IShoppingCartService {

    ShoppingCart getById(long idCart) throws NotFoundException;
    double pay(long idCart) throws NotFoundException, IllegalOperationException;

    ShoppingCart create();
    ShoppingCart addProductToCart(long idCart, CartProduct requestBody)
            throws NotFoundException, IllegalOperationException;

    void delete(long idCart) throws NotFoundException;

}

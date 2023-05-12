package sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.logic;

import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct;
import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;

public interface ICartProductService {
    
    CartProduct create(Product product, int amount);

    CartProduct save(CartProduct cartProduct);
}

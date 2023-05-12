package sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.ICartProductRepository;
import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;

@Service
public class CartProductService implements ICartProductService {

    @Autowired
    private ICartProductRepository repo;

    @Override
    public CartProduct create(Product product, int amount) {
        return this.repo.save(new CartProduct(product, amount));
    }

    @Override
    public CartProduct save(CartProduct cartProduct) {
        return this.repo.save(cartProduct);
    }
}

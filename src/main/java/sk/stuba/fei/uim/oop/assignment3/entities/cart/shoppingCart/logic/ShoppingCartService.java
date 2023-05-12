package sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.logic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.logic.ICartProductService;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.web.CartProduct;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.data.IShoppingCartRepository;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.data.ShoppingCart;
import sk.stuba.fei.uim.oop.assignment3.entities.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.entities.product.logic.IProductService;
import sk.stuba.fei.uim.oop.assignment3.exceptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

@Service
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private IShoppingCartRepository repo;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICartProductService cartProductService;

    @Override
    public ShoppingCart create() {
        return this.repo.save(new ShoppingCart());
    }

    @Override
    public ShoppingCart getById(long idCart) throws NotFoundException {
        ShoppingCart sc = this.repo.findCartById(idCart);
        if (sc == null) {
            throw new NotFoundException();
        }
        return sc;
    }

    @Override
    public void delete(long idCart) throws NotFoundException {
        ShoppingCart sc = this.repo.findCartById(idCart);
        if (sc == null) {
            throw new NotFoundException();
        }
        this.repo.delete(sc);
    }

    @Override
    public ShoppingCart addProductToCart(long idCart, CartProduct requestBody) throws NotFoundException, IllegalOperationException {
        ShoppingCart cart = this.repo.findCartById(idCart);
        Product product = this.productService.getById(requestBody.getProductId());
        if (cart == null || product == null) {
            throw new NotFoundException();
        }
        if (cart.isPayed() || product.getAmount() < requestBody.getAmount()) {
            throw new IllegalOperationException();
        }
        ArrayList<sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct> shoppingList = new ArrayList<>(
                cart.getShoppingList());
        sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct cartProduct = null;

        for (sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct cp : shoppingList) {
            if (cp.getProduct().getId() == requestBody.getProductId()){
                cartProduct = cp;
                break;
            }
        }

        if (cartProduct != null){
            cartProduct.setAmount(cartProduct.getAmount() + requestBody.getAmount());
            this.cartProductService.save(cartProduct);
        }
        else {
            cartProduct = this.cartProductService.create(product, requestBody.getAmount());
            cart.getShoppingList().add(cartProduct);
        }

        this.productService.decreaseAmount(product, requestBody.getAmount());

        return this.repo.save(cart);
    }

    @Override
    public double pay(long idCart) throws NotFoundException, IllegalOperationException {
        ShoppingCart cart = this.repo.findCartById(idCart);
        if (cart == null) {
            throw new NotFoundException();
        }
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }
        double price = 0;
        for (sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct product : cart.getShoppingList()) {
            price += product.getAmount() * product.getProduct().getPrice();
        }

        cart.setPayed(true);
        this.repo.save(cart);

        return price;
    }

}

package sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.web.CartProduct;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.logic.IShoppingCartService;
import sk.stuba.fei.uim.oop.assignment3.exceptions.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exceptions.NotFoundException;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    IShoppingCartService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ShoppingCartResponse getCart(@PathVariable("id") long idCart) throws NotFoundException {
        return new ShoppingCartResponse(this.service.getById(idCart));
    }

    @GetMapping(value = "/{id}/pay")
    public String pay(@PathVariable("id") long idCart) throws NotFoundException, IllegalOperationException {
        return Double.toString(this.service.pay(idCart));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShoppingCartResponse> addCart() {
        return new ResponseEntity<>(new ShoppingCartResponse(this.service.create()), HttpStatus.CREATED);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}/add")
    public ShoppingCartResponse addProductToCart(@PathVariable("id") long idCart, @RequestBody CartProduct requestBody)
            throws NotFoundException, IllegalOperationException {
        return new ShoppingCartResponse(this.service.addProductToCart(idCart, requestBody));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") long idCart) throws NotFoundException {
        this.service.delete(idCart);
    }

}

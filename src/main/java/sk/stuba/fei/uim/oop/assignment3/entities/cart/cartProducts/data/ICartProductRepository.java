package sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartProductRepository extends JpaRepository<CartProduct, Long>{
    
}

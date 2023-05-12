package sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{

    ShoppingCart findCartById(Long id);
}

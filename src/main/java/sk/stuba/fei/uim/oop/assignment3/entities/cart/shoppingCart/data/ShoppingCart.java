package sk.stuba.fei.uim.oop.assignment3.entities.cart.shoppingCart.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.entities.cart.cartProducts.data.CartProduct;

@Getter
@Setter
@Entity
public class ShoppingCart {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(orphanRemoval = true)
  private List<CartProduct> shoppingList;

  private boolean payed;

  public ShoppingCart() {
    this.shoppingList = new ArrayList<>();
    this.payed = false;
  }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.carts.CartsWrapper;
import dkgg2012group22imat.view.entrance.carts.SuperCartProductsPanel;
import dkgg2012group22imat.view.entrance.carts.SuperCartsPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class CartsWrapperController {

    CartsWrapper view;

    CartsWrapperController(CartsWrapper aWrapper) {

        System.out.println("SavedSuperPanel initiated");
        Model m = Model.getInstance();
        m.reset();
        List<Product> l = m.getOffers();
        for (Product p : l) {
            m.addToShoppingCart(p);
        }
        m.saveNewCart(m.getShoppingCart().getItems(), "TACOS BUFFE");
        m.placeOrder();
        System.out.println("Orders in history: " + m.getOrders().size());
        System.out.println("Favorited carts: " + m.getSavedCarts().size());
        
        view = aWrapper;
        view.add(new SuperCartsPanel(this));
    }

    void showCart(SavedCart cart) {
        view.removeAll();
        view.add(new SuperCartProductsPanel(cart, this));
        view.updateUI();
    }

    void showAllCarts() {
        view.removeAll();
        view.add(new SuperCartsPanel(this));
        view.updateUI();
    }
}

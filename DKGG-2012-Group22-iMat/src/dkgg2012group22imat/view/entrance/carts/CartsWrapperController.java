/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.model.SavedCart;

/**
 *
 * @author jonas
 */
public class CartsWrapperController {

    CartsWrapper view;

    CartsWrapperController(CartsWrapper aWrapper) {
 
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

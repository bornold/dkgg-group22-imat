/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.carts.CartsWrapper;
import dkgg2012group22imat.view.entrance.carts.SuperCartProductsPanel;
import dkgg2012group22imat.view.entrance.carts.SuperCartsPanel;

/**
 *
 * @author jonas
 */
public class CartsWrapperController {

    CartsWrapper view;

    public CartsWrapperController(CartsWrapper aWrapper) {
 
        view = aWrapper;
        view.add(new SuperCartsPanel(this));
    }

    public void showCart(SavedCart cart) {
        view.removeAll();
        view.add(new SuperCartProductsPanel(cart, this));
        view.updateUI();
    }

    public void showAllCarts() {
        view.removeAll();
        view.add(new SuperCartsPanel(this));
        view.updateUI();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.controller.entrance.CartsWrapperController;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.carts.CartProductPanel;
import dkgg2012group22imat.view.entrance.carts.CartProductPanel;
import dkgg2012group22imat.view.entrance.carts.SuperCartProductsPanel;
import dkgg2012group22imat.view.entrance.carts.SuperCartProductsPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class SuperCartProductsController {

    SavedCart cart;
    CartsWrapperController parent;
    SuperCartProductsPanel view;
    List<ShoppingItem> items;
    Model m = Model.getInstance();
    public SuperCartProductsController(SavedCart aCart, CartsWrapperController aParent, 
            SuperCartProductsPanel aView) {
        this.cart = aCart;
        this.parent = aParent;
        this.view = aView;
        view.cartName.setText(cart.getName());
        //TODO WARNING typecast double to int
        view.priceLabel.setText("total kostnad " + (int)cart.getTotalPrice());
        items = cart.getItems();
        for(ShoppingItem si : items) {
            view.productsPanel.add(new CartProductPanel(si));
        }
    }

    public void hide() {
        parent.showAllCarts();
    }

    public void addAll() {
        m.addToShoppingCart(items);
    }
}

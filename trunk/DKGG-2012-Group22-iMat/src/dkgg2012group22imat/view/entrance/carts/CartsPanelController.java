/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.view.entrance.carts.SuperCartsPanelController;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.carts.CartPanel;
import dkgg2012group22imat.view.entrance.carts.CartsPanel;
import java.util.List;

/**
 *
 * @author jonas
 */
public class CartsPanelController {

    List<SavedCart> carts;
    SuperCartsPanelController parent;
    CartsPanel view;

    CartsPanelController(List<SavedCart> aCarts, SuperCartsPanelController aParent, CartsPanel aView) {
        this.carts = aCarts;
        this.parent = aParent;
        this.view = aView;

        for (SavedCart sv : carts) {
            view.add(new CartPanel(sv, this));
        }
    }

    void showCart(SavedCart cart) {
        parent.showCart(cart);
    }
}

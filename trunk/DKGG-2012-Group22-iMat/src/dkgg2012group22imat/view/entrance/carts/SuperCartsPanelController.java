/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.view.entrance.carts.CartsWrapperController;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.carts.CartsPanel;
import dkgg2012group22imat.view.entrance.carts.SuperCartsPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.Order;

/**
 *
 * @author jonas
 */
public class SuperCartsPanelController {

    CartsWrapperController parent;
    SuperCartsPanel view;

    Model m = Model.getInstance();
    SuperCartsPanelController(CartsWrapperController aParent, SuperCartsPanel aView) {
        this.view = aView;
        this.parent = aParent;

        view.favoriteCartsPanel.add(new CartsPanel(m.getSavedCartHistory(), this));
        view.historyCartsPanel.add(new CartsPanel(m.getSavedCarts(), this));
        
    }

    void showCart(SavedCart cart) {
        parent.showCart(cart);
    }
}

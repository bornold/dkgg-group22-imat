/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.model.SavedCartListener;
import dkgg2012group22imat.view.entrance.carts.CartsPanel;
import dkgg2012group22imat.view.entrance.carts.SuperCartsPanel;
import java.util.EventObject;

/**
 *
 * @author jonas
 */
public class SuperCartsPanelController implements SavedCartListener {

    CartsWrapperController parent;
    SuperCartsPanel view;
    Model m = Model.getInstance();
    
    public SuperCartsPanelController(CartsWrapperController aParent, SuperCartsPanel aView) {
        this.view = aView;
        this.parent = aParent;

        view.historyCartsPanel.add(new CartsPanel(m.getSavedCartHistory(), this));
        view.favoriteCartsPanel.add(new CartsPanel(m.getSavedCarts(), this));
        
        m.addSavedCartEventListener(this);
    }

    public void showCart(SavedCart cart) {
        parent.showCart(cart);
    }

    public void onSavedCartEvent(EventObject e) {
        view.favoriteCartsPanel.removeAll();
        view.favoriteCartsPanel.add(new CartsPanel(m.getSavedCarts(), this));
    }
}

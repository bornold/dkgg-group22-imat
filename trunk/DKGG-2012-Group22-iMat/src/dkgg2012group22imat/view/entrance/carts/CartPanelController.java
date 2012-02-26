/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.carts.CartPanel;
import dkgg2012group22imat.view.entrance.carts.CartPanel;
import dkgg2012group22imat.view.entrance.carts.CartsPanelController;
import java.awt.Dimension;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartPanelController {

    SavedCart cart;
    CartPanel view;
    CartsPanelController parent;
    Model m = Model.getInstance();
    private List<ShoppingItem> items;
    private Dimension iconSize = new Dimension(20, 20);

    CartPanelController(SavedCart sv, CartsPanelController aParent, CartPanel aView) {
        this.cart = sv;
        this.parent = aParent;
        this.view = aView;
        view.cartName.setText(sv.getName());
        //view.informationLabel.setText(items.size() + " varor för totalt " + (int) sv.getTotalPrice()); //TODO Typecast double to int
        items = sv.getItems();
        int amount = items.size() > 4 ? 4 : items.size();
        switch (amount) {
            case 4:
                view.icon4.setIcon(m.getImageIcon(items.get(3).getProduct(), iconSize));
            case 3:
                view.icon3.setIcon(m.getImageIcon(items.get(2).getProduct(), iconSize));
            case 2:
                view.icon2.setIcon(m.getImageIcon(items.get(1).getProduct(), iconSize));
            case 1:
                view.icon1.setIcon(m.getImageIcon(items.get(0).getProduct(), iconSize));
                break;
        }
    }

    void addAll() {
        m.addToShoppingCart(items);
    }

    void showThis() {
        parent.showCart(cart);
    }
}

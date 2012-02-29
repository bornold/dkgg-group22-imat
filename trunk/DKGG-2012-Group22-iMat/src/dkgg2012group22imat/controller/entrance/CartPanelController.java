/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.carts.CartPanel;
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
    private Dimension iconSize = new Dimension(60, 46);

    public CartPanelController(SavedCart sv, CartsPanelController aParent, CartPanel aView) {
        this.cart = sv;
        this.parent = aParent;
        this.view = aView;
        view.cartName.setText(sv.getName());
        items = sv.getItems();
        view.informationLabel.setText(items.size() + " varor för totalt " + (int) sv.getTotalPrice()+" kr");
        int amount = items.size() > 4 ? 4 : items.size();
        switch (amount) {
            case 4:
                view.icon4.setImage(m.getImageIcon(items.get(3).getProduct(), iconSize));
            case 3:
                view.icon3.setImage(m.getImageIcon(items.get(2).getProduct(), iconSize));
            case 2:
                view.icon2.setImage(m.getImageIcon(items.get(1).getProduct(), iconSize));
            case 1:
                view.icon1.setImage(m.getImageIcon(items.get(0).getProduct(), iconSize));
                break;
        }
    }

    public void addAll() {
        m.addToShoppingCart(items);
    }

    public void showThis() {
        parent.showCart(cart);
    }
}

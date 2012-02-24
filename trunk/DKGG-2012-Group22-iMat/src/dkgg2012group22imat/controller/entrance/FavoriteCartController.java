/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.entrance.FavoriteCartPanel;
import java.awt.Dimension;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class FavoriteCartController {

    private Dimension iconSize = new Dimension(20, 20);
    private FavoriteCartPanel view;
    private SavedCart cart;
    private List<ShoppingItem> items;
    Model m = Model.getInstance();
    private FavoriteCartsController parent;

    public FavoriteCartController(SavedCart sc, FavoriteCartsController parent, FavoriteCartPanel favoriteCartPanel) {
        this.cart = sc;
        this.view = favoriteCartPanel;
        this.parent = parent;
        view.nameLabel.setName(sc.getName());
        items = sc.getItems();
        view.informationLabel.setText(items.size() + " varor för totalt " + (int) sc.getTotalPrice());
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

    public void addAll() {
        m.addToShoppingCart(items);
    }

    public void show() {
        parent.show(items, cart.getName());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view.entrance.carts;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.entrance.carts.CartProductPanel;
import java.awt.Dimension;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartProductController {
    ShoppingItem item;
    CartProductPanel view;
    Model m = Model.getInstance();
    Dimension d = new Dimension(20, 20);
    public CartProductController(ShoppingItem si, CartProductPanel cartPanel){
        this.item = si;
        this.view = cartPanel;
        view.icon.setIcon(m.getImageIcon(si.getProduct(), d));
        view.nameLabel.setText(si.getProduct().getName());
        view.informationLabel.setText((int)si.getAmount() + "st, totalt " + (int)si.getTotal()+"kr");
    }

    public void addItem() {
        m.addToShoppingCart(item);
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.entrance.SavedCartProductPanel;
import java.awt.Dimension;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class SavedCartProductController {
    ShoppingItem item;
    SavedCartProductPanel view;
    Model m = Model.getInstance();
    Dimension d = new Dimension(20, 20);
    public SavedCartProductController(ShoppingItem si, SavedCartProductPanel cartPanel){
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

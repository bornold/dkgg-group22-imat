/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.SavedCartInterface;
import dkgg2012group22imat.view.entrance.SavedCartContainerPanel;
import dkgg2012group22imat.view.entrance.SavedCartPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class SavedCartContainerController {

    SavedCartContainerPanel view;
    List<ShoppingItem> items;
    SavedCartInterface parent;
    Model m = Model.getInstance();
    public SavedCartContainerController(SavedCartInterface _parent, List<ShoppingItem> _items, String name, SavedCartContainerPanel _view){
        this.items = _items;
        this.view = _view;
        this.parent = _parent;
        view.cartNameLabel.setText(name);
        view.cartPriceLabel.setText("price");//TODO bad bad bad uppbyggnad
        view.innerPanel.add(new SavedCartPanel(items));
    }

    public void hide() {
        parent.showCarts();
    }

    public void addAll() {
        m.addToShoppingCart(items);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.view.entrance.SavedCartPanel;
import dkgg2012group22imat.view.entrance.SavedCartProductPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */

public class SavedCartController {
    SavedCartPanel view;
    List<ShoppingItem> items;
    public SavedCartController(SavedCartPanel _view, List<ShoppingItem> _items){
        this.view = _view;
        this.items = _items;
        for(ShoppingItem si : items) {
            view.add(new SavedCartProductPanel(si));
        }
    }
}

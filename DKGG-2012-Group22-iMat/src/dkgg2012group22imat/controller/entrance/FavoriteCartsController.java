/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.SavedCartInterface;
import dkgg2012group22imat.view.entrance.FavoriteCartPanel;
import dkgg2012group22imat.view.entrance.FavoriteCartsPanel;
import dkgg2012group22imat.view.entrance.SavedCartContainerPanel;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class FavoriteCartsController implements SavedCartInterface {

    private FavoriteCartsPanel view;
    private SavedCartSuperController parent;
    private Model m = Model.getInstance();

    public FavoriteCartsController(SavedCartSuperController parent, FavoriteCartsPanel favoriteCartsPanel) {
        this.view = favoriteCartsPanel;
        this.parent = parent;
        //TODO REMOVE TEMP CODE
        List<Product> prodTemp = m.getOffers();
        for (int i = 0; i < 10; i++) {
            List<ShoppingItem> itemTemp = new ArrayList<ShoppingItem>();
            for (Product p : prodTemp) {
                itemTemp.add(new ShoppingItem(p));
            }
            m.saveNewCart(itemTemp, "Favorite" + i);
        }
        //TEMP CODE END

        List<SavedCart> temp = m.getSavedCarts();
        for (SavedCart sc : temp) {
            view.add(new FavoriteCartPanel(sc, this));
        }
        view.updateUI();
    }

    void show(List<ShoppingItem> items, String name) {
        parent.hideHistory();
        view.removeAll();
        view.add((new SavedCartContainerPanel(this, items, name)));
        view.updateUI();
        parent._updateUI();
    }

    public void showCarts() {
        parent.showHistory();
        view.removeAll();
        List<SavedCart> temp = m.getSavedCarts();
        for (SavedCart sc : temp) {
            view.add(new FavoriteCartPanel(sc, this));
        }
        view.updateUI();
        parent._updateUI();
    }
}

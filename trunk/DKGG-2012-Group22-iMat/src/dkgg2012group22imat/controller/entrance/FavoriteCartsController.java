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
    private Model m = Model.getInstance();

    public FavoriteCartsController(FavoriteCartsPanel favoriteCartsPanel) {
        this.view = favoriteCartsPanel;
        //TODO REMOVE TEMP CODE
        List<Product> prodTemp = m.getOffers();
        List<ShoppingItem> itemTemp = new ArrayList<ShoppingItem>();
        for (Product p : prodTemp) {
            itemTemp.add(new ShoppingItem(p));
        }
        m.saveNewCart(itemTemp, "Favorite");
        //TEMP CODE END
        showCarts();
    }

    void show(List<ShoppingItem> items, String name) {
        view.removeAll();
        view.add((new SavedCartContainerPanel(this, items, name)));
        view.updateUI();
    }

    public void showCarts() {
        view.removeAll();
        List<SavedCart> temp = m.getSavedCarts();
        for (SavedCart sc : temp) {
            view.add(new FavoriteCartPanel(sc, this));
        }
        view.updateUI();
    }
}

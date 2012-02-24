/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.SavedCartInterface;
import dkgg2012group22imat.view.entrance.HistoryCartPanel;
import dkgg2012group22imat.view.entrance.HistoryCartsPanel;
import dkgg2012group22imat.view.entrance.SavedCartContainerPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class HistoryCartsController implements SavedCartInterface {

    private HistoryCartsPanel view;
    private Model m = Model.getInstance();
    private SavedCartSuperController parent;

    public HistoryCartsController(SavedCartSuperController parent, HistoryCartsPanel historyCartsPanel) {
        this.view = historyCartsPanel;
        this.parent = parent;
        //TEMP CODE
        m.reset();
        List<Product> prds = m.getOffers();
        for (int i = 0; i < 1; i++) {
            for (Product p : prds) {
                m.addToShoppingCart(p);
                m.addFavorite(p);
            }
            m.placeOrder();
        }

        // TEMP CODE END

        List<Order> temp = m.getOrders();
        for (Order o : temp) {
            view.add(new HistoryCartPanel(o, this));
        }
        view.updateUI();
        
    }

    void show(List<ShoppingItem> items, String name) {
        parent.hideFavorite();
        view.removeAll();
        view.add((new SavedCartContainerPanel(this, items, name)));
        view.updateUI();
    }

    public void showCarts() {
        parent.showFavorite();
        view.removeAll();
        List<Order> temp = m.getOrders();
        for (Order o : temp) {
            view.add(new HistoryCartPanel(o, this));
        }
        view.updateUI();
    }
}

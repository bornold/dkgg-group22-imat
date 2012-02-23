/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
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
public class HistoryCartsController {

    private HistoryCartsPanel view;
    private Model m = Model.getInstance();

    public HistoryCartsController(HistoryCartsPanel historyCartsPanel) {
        System.out.println("HistoryCartsController ini");
        this.view = historyCartsPanel;
        
        //TEMP CODE
        m.reset();
        for (int i = 0; i < 2; i++) {
            List<Product> prds = m.getOffers();
            for (Product p : prds) {
                m.addToShoppingCart(p);
            }
            m.placeOrder();
        }
        // TEMP CODE END
        
        showCarts();
      
    }


    void show(List<ShoppingItem> items, String name) {
        view.removeAll();
        view.add((new SavedCartContainerPanel(this, items, name)));
        view.updateUI();
    }

    void showCarts() {
        view.removeAll();
        List<Order> temp = m.getOrders();
        if (temp.isEmpty()) {
            System.out.println("No history!");
        } else {
            System.out.println("Orders in history:" + temp.size());
        }
        for (Order o : temp) {
            view.add(new HistoryCartPanel(o, this));
        }
        view.updateUI();
    }
}

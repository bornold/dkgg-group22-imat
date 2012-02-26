/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.entrance.FavoriteCartsPanel;
import dkgg2012group22imat.view.entrance.HistoryCartsPanel;
import dkgg2012group22imat.view.entrance.SavedCartSuperPanel;
import java.awt.Dimension;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class SavedCartSuperController {

    private SavedCartSuperPanel view;
    private HistoryCartsPanel hcp;
    private FavoriteCartsPanel fcp;

    public SavedCartSuperController(SavedCartSuperPanel cartSuperPanel) {
        //TODO REMOVE TEMP CODE
        //TEMP CODE BEGIN
        System.out.println("SavedSuperPanel initiated");
        Model m = Model.getInstance();
        List<Product> l = m.getOffers();
        for (Product p : l) {
            m.addToShoppingCart(p);
        }
        m.saveNewCart(m.getShoppingCart().getItems(), "TACOS BUFFE");
        m.placeOrder();
        System.out.println("Orders in history: " + m.getOrders().size());
        System.out.println("Favorited carts: " + m.getSavedCarts().size());
        //TEMP CODE END
        
        this.view = cartSuperPanel;
        hcp = new HistoryCartsPanel(this);
        fcp = new FavoriteCartsPanel(this);
        view.historyPanel.add(hcp);
        view.favoritePanel.add(fcp);
    }

    public void hideHistory() {
        view.remove(view.historyScrollPane);
        view.favoriteScrollPane.setSize(getSize());
        view.favoritePanel.setSize(getSize());
        _updateUI();
    }

    public void hideFavorite() {
        view.remove(view.favoriteScrollPane);
        view.historyScrollPane.setSize(getSize());
        view.historyPanel.setSize(getSize());
        _updateUI();

    }

    public void showHistory() {
        view.add(view.historyScrollPane);
        _updateUI();

    }

    public void showFavorite() {
        view.add(view.favoriteScrollPane, 0);
        _updateUI();

    }

    public void _updateUI() {
        view.revalidate();
        view.repaint();
        view.updateUI();
    }

    public Dimension getSize() {
        return view.getSize();
    }
}

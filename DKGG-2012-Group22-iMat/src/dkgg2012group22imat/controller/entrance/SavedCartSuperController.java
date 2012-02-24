/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.view.entrance.FavoriteCartsPanel;
import dkgg2012group22imat.view.entrance.HistoryCartsPanel;
import dkgg2012group22imat.view.entrance.SavedCartSuperPanel;

/**
 *
 * @author jonas
 */
public class SavedCartSuperController {

    private SavedCartSuperPanel view;
    private HistoryCartsPanel hcp;
    private FavoriteCartsPanel fcp;

    public SavedCartSuperController(SavedCartSuperPanel cartSuperPanel) {
        this.view = cartSuperPanel;
        hcp = new HistoryCartsPanel(this);
        fcp = new FavoriteCartsPanel(this);
        view.historyPanel.add(hcp);
        view.favoritePanel.add(fcp);
    }

    public void hideHistory() {
        view.remove(view.historyScrollPane);
        _updateUI();
    }

    public void hideFavorite() {
        view.remove(view.favoriteScrollPane);
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
}

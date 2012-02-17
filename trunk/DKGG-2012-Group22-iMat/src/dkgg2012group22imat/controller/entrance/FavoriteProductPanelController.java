/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductPanel;
import dkgg2012group22imat.view.entrance.FavoriteProductsPanel;
import java.util.Iterator;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */

//TODO Implement listner on added favorit
public class FavoriteProductPanelController {

    Model m = Model.getInstance();
    List<Product> items;
    public FavoriteProductsPanel favoriteProductsPanel;

    public FavoriteProductPanelController(FavoriteProductsPanel favoriteProductsPanel) {
        this.favoriteProductsPanel = favoriteProductsPanel;
        System.out.println("favorit prod pan controller inni");
        items = m.getFavorites();
        if (items.isEmpty()) {
            System.out.println("No favo prod");
        }
        Iterator it = items.iterator();
        while (it.hasNext()) {
            favoriteProductsPanel.add(new ProductPanel((Product)it.next()));
        }
    }
}

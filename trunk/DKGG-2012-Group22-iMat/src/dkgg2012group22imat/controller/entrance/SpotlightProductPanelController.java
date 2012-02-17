/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductPanel;
import dkgg2012group22imat.view.entrance.SpotlightProductsPanel;
import java.util.Iterator;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class SpotlightProductPanelController {

    Model m = Model.getInstance();
    List<Product> items;
    public SpotlightProductsPanel spotlightProductsPanel;

    public SpotlightProductPanelController(SpotlightProductsPanel panel) {
        this.spotlightProductsPanel = panel;
        System.out.println("spotlight prod pan controller inni");
        items = m.getOffers();
        Iterator it = items.iterator();    
        while (it.hasNext()) {
            spotlightProductsPanel.add(new ProductPanel((Product)it.next()));
        }
    }
}

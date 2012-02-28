/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Category;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductsPanel;
import dkgg2012group22imat.view.shop.CategoriesPanel;
import dkgg2012group22imat.view.shop.ShopPanel;

/**
 *
 * @author jonas
 */
public class ShopPanelController {
    
    Model m = Model.getInstance();
    ShopPanel view;
    
    public ShopPanelController(ShopPanel view) {
        this.view = view;
        this.view.leftPanel.add(new CategoriesPanel(this));
        this.view.mainPanel.add(new ProductsPanel(m.getOffers(), 3));
    }
    
    public void showCategory(Category c) {
        this.view.mainPanel.removeAll();
        this.view.mainPanel.add(new ProductsPanel(m.getProductsByCategory(c), 3));
    }
}


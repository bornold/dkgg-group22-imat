/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Category;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductsPanel;
import dkgg2012group22imat.view.shop.CategoriesPanel;
import dkgg2012group22imat.view.shop.SearchPanel;
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
        CategoriesPanel cp = new CategoriesPanel(this);
        this.view.leftPanel.add(cp);
        cp.controller.showAll();
    }

    public void showCategory(Category c) {
        this.view.mainPanel.removeAll();
        this.view.mainPanel.add(new ProductsPanel(m.getProducts(c)));
        this.view.titleLabel.setText(c.getName());
    }

    public void showAll() {
        this.view.mainPanel.removeAll();
        this.view.mainPanel.add(new ProductsPanel(m.getProducts()));
        this.view.titleLabel.setText("Alla varor");
        view.revalidate();
        view.repaint();
    }
    
    public void showSearch() {
        this.view.mainPanel.removeAll();
        this.view.mainPanel.add(new SearchPanel());
        this.view.titleLabel.setText("Sök");
        view.revalidate();
        view.repaint();
    }
    
    public void showFavorites() {
        this.view.mainPanel.removeAll();
        this.view.mainPanel.add(new ProductsPanel(m.getFavorites()));
        this.view.titleLabel.setText("Favoriter");
        view.revalidate();
        view.repaint();
    }
}

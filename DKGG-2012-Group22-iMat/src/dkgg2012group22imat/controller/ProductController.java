/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductPanel;
import java.awt.Dimension;
import javax.swing.Icon;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class ProductController {

    Model m = Model.getInstance();
    Product p;
    ProductPanel view;

    public ProductController(Product p, ProductPanel panel) {
        System.out.println("Product panel controller inni");
        this.p = p;
        this.view = panel;
        view.productNameLabel.setText(p.getName());
        view.iconLabel.setIcon(m.getImageIcon(p, new Dimension(80, 80)));
        view.priceLabel.setText(p.getPrice() + p.getUnit());
        view.quantityLabel.setText(p.getUnitSuffix());
        setFavoButton();

    }

    public void favorize() {
        if (m.isFavorite(p)) {
            m.removeFavorite(p);
        } else {
            m.addFavorite(p);
        }
        setFavoButton();
    }

    public boolean isFavorite() {
        return m.isFavorite(p);
    }

    public void addToCart() {
        m.addToShoppingCart(p, view.getAmount());
    }

    private void setFavoButton() {
        if (m.isFavorite(p)) {
            view.favoriteToggleButton.setText("isFavo");
        } else {
            view.favoriteToggleButton.setText("Favo");
        }
    }
}

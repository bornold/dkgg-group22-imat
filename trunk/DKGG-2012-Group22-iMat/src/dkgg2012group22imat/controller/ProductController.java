/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductPanel;
import java.awt.Dimension;
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
        view.priceLabel.setText(p.getPrice() + "kr");
        view.quantityLabel.setText(p.getUnit() + "/" + p.getUnitSuffix());
    }

    public void favorize() {
        if (m.isFavorite(p)) {
            m.removeFavorite(p);
        } else {
            m.addFavorite(p);
        }
    }

    public void addToCart() {
        m.addToShoppingCart(p, view.getAmount());
    }
}

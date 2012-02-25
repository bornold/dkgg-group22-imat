/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.FavoriteListener;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductPanel;
import java.awt.Dimension;
import java.awt.Point;
import java.util.EventObject;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;

/**
 *
 * @author jonas
 */
public class ProductController implements FavoriteListener {

    Model m = Model.getInstance();
    Product p;
    ProductPanel view;
    Dimension small = new Dimension(150, 150);
    Dimension big = new Dimension(200, 200);
    boolean isEnhanced = false;

    public ProductController(Product p, ProductPanel panel) {
        this.p = p;
        this.view = panel;
        view.productNameLabel.setText(p.getName());
        view.productImageLabel.setImage(m.getImageIcon(p, new Dimension(266,200)));
        view.priceLabel.setText(p.getPrice() + " " + p.getUnit());
        view.addButton.setVisible(false);
        view.quantitySpinner.setVisible(false);
        view.favoriteToggleButton.setVisible(false);
        view.unitLabel.setVisible(false);
        view.unitLabel.setText(p.getUnitSuffix());
        setFavoButton();
        m.addEventListener(this);
    }

    public void favorize() {
        if (m.isFavorite(p)) {
            m.removeFavorite(p);
        } else {
            m.addFavorite(p);
        }
        setFavoButton();
    }

    
    private void setFavoButton() {
        if (m.isFavorite(p)) {
            view.favoriteToggleButton.setIcon(view.favoriteToggleButton.getPressedIcon());
            view.favoriteToggleButton.setRolloverIcon(view.favoriteToggleButton.getRolloverSelectedIcon());
        } else {
            view.favoriteToggleButton.setIcon(view.favoriteToggleButton.getDisabledIcon());
            view.favoriteToggleButton.setRolloverIcon(view.favoriteToggleButton.getDisabledSelectedIcon());
        }
    }

    public void addToCart() {
        m.addToShoppingCart(p, view.getAmount());
        view.setAmount(1);
    }

    public void enhance() {
        if (!isEnhanced) {
            Point p = view.getLocation();
            int x = p.x - (big.width - small.width) / 2;
            int y = p.y - (big.height - small.height) / 2;
            view.setLocation(x, y);
            view.setSize(big);
            view.expandShadow();
            view.addButton.setVisible(true);
            view.unitLabel.setVisible(true);
            view.quantitySpinner.setVisible(true);
            view.favoriteToggleButton.setVisible(true);
            isEnhanced = true;
        }
    }

    public void defile() {
        if (isEnhanced) {
            Point p = view.getLocation();
            int x = p.x + (big.width - small.width) / 2;
            int y = p.y + (big.height - small.height) / 2;
            view.addButton.setVisible(false);
            view.quantitySpinner.setVisible(false);
            view.favoriteToggleButton.setVisible(false);
            view.unitLabel.setVisible(false);
            view.resetShadow();
            view.setLocation(x, y);
            view.setSize(small);
            isEnhanced = false;
        }
    }

    public void handleFavoriteEvent(EventObject e) {
        setFavoButton();
    }
}

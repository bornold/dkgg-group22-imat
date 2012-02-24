/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartProductPanel;
import java.awt.Dimension;
import java.util.EventObject;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class CartProductController {

    Model m = Model.getInstance();
    Product p;
    CartProductPanel view;
    Dimension small = new Dimension(150, 150);
    Dimension big = new Dimension(200, 200);

    public CartProductController(Product p, CartProductPanel panel) {
        this.p = p;
        this.view = panel;
        view.productNameLabel.setText(p.getName());
        view.iconLabel.setIcon(m.getImageIcon(p, new Dimension(80, 80)));
        view.priceLabel.setText(p.getPrice()+"");
        view.deleteButton.setVisible(false);
//        view.quantityLabel.setText(p.getUnitSuffix());
        view.favoriteToggleButton.setVisible(false);
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

    private void setFavoButton() {
        if (m.isFavorite(p)) {
            view.favoriteToggleButton.setIcon(view.favoriteToggleButton.getPressedIcon());
        } else {
            view.favoriteToggleButton.setIcon(view.favoriteToggleButton.getDisabledIcon());
        }
    }
    public void removeFromCart() {
        m.removeFromShoppingCart(p);
    }
    public void hooverd() {
        view.deleteButton.setVisible(true);
    }

    public void dehoover() {
        view.deleteButton.setVisible(false);
    }
    public void spinnerChanged(int i){
        view.priceLabel.setText(p.getPrice()*i+"");
    }
    public void handleFavoriteEvent(EventObject e) {
        setFavoButton();
    }
}

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
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartProductController {

    Model m = Model.getInstance();
    ShoppingItem si;
    CartProductPanel view;
    Dimension small = new Dimension(150, 150);
    Dimension big = new Dimension(200, 200);

    public CartProductController(ShoppingItem si, CartProductPanel panel) {
        this.si = si;
        this.view = panel;
        view.productNameLabel.setText(si.getProduct().getName());
        view.iconLabel.setIcon(m.getImageIcon(si.getProduct(), new Dimension(80, 80)));
        view.priceLabel.setText(si.getProduct().getPrice()+"");
        view.deleteButton.setVisible(false);
//        view.quantityLabel.setText(p.getUnitSuffix());
        view.favoriteToggleButton.setVisible(false);
        setFavoButton();

    }

    public void favorize() {
        if (m.isFavorite(si.getProduct())) {
            m.removeFavorite(si.getProduct());
        } else {
            m.addFavorite(si.getProduct());
        }
        setFavoButton();
    }

    private void setFavoButton() {
        if (m.isFavorite(si.getProduct())) {
            view.favoriteToggleButton.setIcon(view.favoriteToggleButton.getPressedIcon());
            view.favoriteToggleButton.setRolloverIcon(view.favoriteToggleButton.getRolloverSelectedIcon());
        } else {
            view.favoriteToggleButton.setIcon(view.favoriteToggleButton.getDisabledIcon());
            view.favoriteToggleButton.setRolloverIcon(view.favoriteToggleButton.getDisabledSelectedIcon());
        }
    }
    public void removeFromCart() {
        m.removeFromShoppingCart(si.getProduct());
    }
    public void hooverd() {
        view.deleteButton.setVisible(true);
        view.favoriteToggleButton.setVisible(true);
    }

    public void dehoover() {
        view.deleteButton.setVisible(false);
        view.favoriteToggleButton.setVisible(false);
    }
    public void spinnerChanged(int i){
        view.priceLabel.setText(si.getProduct().getPrice()*i+"");
    }
    public void handleFavoriteEvent(EventObject e) {
        setFavoButton();
    }
}

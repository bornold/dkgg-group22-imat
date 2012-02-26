/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartPanel;
import dkgg2012group22imat.view.CartProductPanel;
import dkgg2012group22imat.view.CartWithProductsPanel;
import dkgg2012group22imat.view.DKGG2012Group22iMatApp;
import dkgg2012group22imat.view.IMatUtilities;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.ColorModel;
import java.awt.image.ImageConsumer;
import java.util.EventObject;
import java.util.Hashtable;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import org.jdesktop.application.Application;
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
        view.productImageLabel.setImage(m.getImageIcon(si.getProduct(), new Dimension(140, 106)));
        
        view.priceLabel.setText((int)si.getProduct().getPrice()+"kr");
        view.deleteButton.setVisible(false);
//        view.quantityLabel.setText(p.getUnitSuffix());
        view.unitLabel.setText(si.getProduct().getUnitSuffix()+" för");
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
    
    public void delete() {
        
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
        view.priceLabel.setText((int)si.getProduct().getPrice()*i+"kr");
    }
    public void handleFavoriteEvent(EventObject e) {
        setFavoButton();
    }
    
    
}

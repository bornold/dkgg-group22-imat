/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.controller.iMatViewController.MainView;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartPanel;
import dkgg2012group22imat.model.IMatUtilities;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.model.SavedCartListener;
import dkgg2012group22imat.view.SaveCartOverlay;
import java.awt.Component;
import java.awt.Point;
import java.util.EventObject;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;

/**
 *
 * @author jonas
 */
public class CartPanelController implements ShoppingCartListener, SavedCartListener {

    Model m;
    ShoppingCart sc;
    CartPanel view;
    Component saveCartDialog;
    String name;

    public CartPanelController(CartPanel cartPanel) {
        this.m = Model.getInstance();
        this.sc = this.m.getShoppingCart();
        this.sc.addShoppingCartListener(this);
        this.view = cartPanel;
        this.name = "Favorit" + m.getSavedCarts().size();
        this.shoppingCartChanged();
        m.addSavedCartEventListener(this);
    }

    public void gotoCheckout() {
        IMatUtilities.getIMatViewController().setCurrentView(MainView.CHECKOUT);
    }

    public void openSaveCartDialog() {
        saveCartDialog = new SaveCartOverlay(this);
        saveCartDialog.setName(this.name);
        Point p = IMatUtilities.getLocationRelativeToFrame(view.toggleFavouriteCart.getLocationOnScreen());
        p.x = p.x - (int) saveCartDialog.getPreferredSize().getWidth() + 38;
        p.y = p.y - (int) saveCartDialog.getPreferredSize().getHeight() + 50;
        IMatUtilities.displayOverlay(saveCartDialog, p);
        this.view.toggleFavouriteCart.setEnabled(false);
    }

    public void closeSaveCartDialog() {
        IMatUtilities.removeOverlay(saveCartDialog);

    }

    public int saveCart(String name, boolean overwrite) {
        this.name = name;
        if (m.getSavedCart(this.name) != null && !overwrite) {
            return -1;
        } else {
            m.saveCart(sc.getItems(), this.name);
            view.toggleFavouriteCart.setDisabledIcon(view.toggleFavouriteCart.getDisabledSelectedIcon());
            view.toggleFavouriteCart.setEnabled(false);
            view.toggleFavouriteCart.setText("<html><font color=black>Sparad som " + this.name + "</font></html>");
            return 1;
        }
    }

    public void shoppingCartChanged() {
        view.setTotalPriceText(sc.getItems().size() + " varor för totalt " + (double) Math.round(sc.getTotal() * 100) / 100 + " kr");
        if (sc.getItems().size() > 0) {
            boolean exists = false;
            for (SavedCart saved : m.getSavedCarts()) {
                if (saved.getItems().equals(sc.getItems())) {
                    this.name = saved.getName();
                    exists = true;
                }
            }
            if (!exists) {
                view.toggleFavouriteCart.setText("Spara kundvagnen");
                view.toggleFavouriteCart.setEnabled(true);
                view.toggleFavouriteCart.setDisabledIcon(view.toggleFavouriteCart.getPressedIcon());
                view.toggleFavouriteCart.setVisible(true);
            } else {
                view.toggleFavouriteCart.setDisabledIcon(view.toggleFavouriteCart.getDisabledSelectedIcon());
                view.toggleFavouriteCart.setEnabled(false);
                view.toggleFavouriteCart.setText("<html><font color=black>Sparad som " + this.name + "</font></html>");

            }
        } else {
            view.toggleFavouriteCart.setVisible(false);
        }
    }

    public void onSavedCartEvent(EventObject e) {
    }
}
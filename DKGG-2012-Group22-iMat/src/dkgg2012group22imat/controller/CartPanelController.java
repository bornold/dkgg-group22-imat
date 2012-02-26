/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.controller.iMatViewController.MainView;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartPanel;
import dkgg2012group22imat.view.IMatUtilities;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;

/**
 *
 * @author jonas
 */
public class CartPanelController implements ShoppingCartListener{

    Model m;
    ShoppingCart sc;
    CartPanel view;

    public CartPanelController(CartPanel cartPanel) {
        this.m = Model.getInstance();
        this.sc = this.m.getShoppingCart();
        this.sc.addShoppingCartListener(this);
        this.view = cartPanel;
    }
    
    public void gotoCheckout() {
        IMatUtilities.getIMatViewController().setCurrentView(MainView.CHECKOUT);
    }
    
    public void toggleFavouriteCart() {
        
    }

    public void shoppingCartChanged() {
        view.setTotalPriceText(sc.getItems().size()+" varor för totalt "+sc.getTotal()+" kr");
    }

}
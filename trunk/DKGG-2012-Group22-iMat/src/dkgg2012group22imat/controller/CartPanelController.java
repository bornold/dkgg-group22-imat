/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartPanel;
import dkgg2012group22imat.view.CartProductPanel;
import java.util.Iterator;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartPanelController implements ShoppingCartListener{

    CartPanel view;
    Model m = Model.getInstance();
    List<ShoppingItem> items;
    ShoppingCart shoppingCart;

    public CartPanelController(CartPanel cartPanel) {
        this.view = cartPanel;
        shoppingCart = m.getShoppingCart();
        shoppingCart.addShoppingCartListener(this);
    }

    public void shoppingCartChanged() {
        items = m.getFavorites();
        Iterator it = items.iterator();    
        while (it.hasNext()) {
            view.add(new CartProductPanel((Product)it.next()));
        }
        System.out.println("Cart got increased");
    }
}
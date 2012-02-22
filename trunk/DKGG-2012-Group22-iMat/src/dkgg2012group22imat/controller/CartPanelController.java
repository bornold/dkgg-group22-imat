/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartPanel;
import dkgg2012group22imat.view.CartProductPanel;
import dkgg2012group22imat.view.CartWithProductsPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartPanelController implements ShoppingCartListener {

    private CartPanel view;
    private CartWithProductsPanel cartProductView;
    private Model m = Model.getInstance();
    private List<ShoppingItem> items;
    private ShoppingCart shoppingCart;
    private Product p;

    public CartPanelController(CartPanel cartPanel) {
        this.view = cartPanel;
        this.cartProductView = view.getCartWithProductsPanel();
        shoppingCart = m.getShoppingCart();
        shoppingCart.addShoppingCartListener(this);
    }

    public void shoppingCartChanged() {
        items = shoppingCart.getItems();
        for (ShoppingItem si : items) {
                p = si.getProduct();
                cartProductView.add(new CartProductPanel(p));
        }
            System.out.println("Cart got increased");
            cartProductView.repaint();
    }
}
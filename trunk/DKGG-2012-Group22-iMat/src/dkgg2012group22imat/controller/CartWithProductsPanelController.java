/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartProductPanel;
import dkgg2012group22imat.view.CartWithProductsPanel;
import java.util.List;
import javax.swing.Box;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author magnushuttu
 */
public class CartWithProductsPanelController implements ShoppingCartListener {

    private CartWithProductsPanel view;
    private Model m = Model.getInstance();
    private List<ShoppingItem> items;
    private ShoppingCart shoppingCart;
    private Product p;

    public CartWithProductsPanelController(CartWithProductsPanel cartProductView) {
        this.view = cartProductView;
        shoppingCart = m.getShoppingCart();
        shoppingCart.addShoppingCartListener(this);
    }

    public void shoppingCartChanged() {
        items = shoppingCart.getItems();
        view.getProductListPanel().removeAll();
        for (ShoppingItem si : items) {
            CartProductPanel pane = new CartProductPanel(si);
            view.getProductListPanel().add(pane);
        }
        System.out.println("Cart increased with " + view.getComponents().length);
        view.updateUI();
        view.revalidate();
        view.repaint();
    }
}

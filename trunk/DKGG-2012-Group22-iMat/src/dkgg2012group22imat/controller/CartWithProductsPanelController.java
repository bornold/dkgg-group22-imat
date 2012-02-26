/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartProductPanel;
import dkgg2012group22imat.view.CartWithProductsPanel;
import dkgg2012group22imat.view.IMatUtilities;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author magnushuttu
 */
public class CartWithProductsPanelController implements ShoppingCartListener {

    private static CartWithProductsPanel view;
    private Model m = Model.getInstance();
    private  List<ShoppingItem> items;
    private static List<Product> productList;
    private ShoppingCart shoppingCart;
    private Product p;

    public CartWithProductsPanelController(CartWithProductsPanel cartProductView) {
        this.view = cartProductView;
        shoppingCart = m.getShoppingCart();
        shoppingCart.addShoppingCartListener(this);
        productList = new ArrayList();
    }

    public void shoppingCartChanged() {
        items = shoppingCart.getItems();
        view.getProductListPanel().removeAll();
        
        productList = new ArrayList();
        
        for (ShoppingItem si : items) {
            
            CartProductPanel pane = new CartProductPanel(si);
            productList.add(si.getProduct());
            view.getProductListPanel().add(pane);
        }
        System.out.println("Cart increased with " + view.getComponents().length);
        view.updateUI();
        view.revalidate();
        view.repaint();
    }
    
    public static Rectangle getImageBoundsOf(Product p) {
        CartProductPanel temp = new CartProductPanel(new ShoppingItem(p,1));
        int border = 1;
        int locationx = view.getLocationOnScreen().x + 12 + border;//temp.productImageLabel.getX();
        int locationy = view.getLocationOnScreen().y + (productList.indexOf(p) * temp.getPreferredSize().height) + 19 + border;// temp.productImageLabel.getY();
        Point point = IMatUtilities.getLocationRelativeToFrame(new Point(locationx,locationy));
        Dimension dimension = temp.productImageLabel.getPreferredSize();
        dimension.width = dimension.width-border*2;
        dimension.height = dimension.height-border*2;
        
        return new Rectangle(point,dimension);//productImageBounds.get(p);
    }
}

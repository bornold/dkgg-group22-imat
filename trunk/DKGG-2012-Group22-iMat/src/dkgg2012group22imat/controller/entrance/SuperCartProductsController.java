/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.entrance;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenCallback.EventType;
import dkgg2012group22imat.controller.CartWithProductsPanelController;
import dkgg2012group22imat.model.IMatUtilities;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.model.SavedCart;
import dkgg2012group22imat.view.ProductImageLabel;
import dkgg2012group22imat.view.entrance.carts.CartProductPanel;
import dkgg2012group22imat.view.entrance.carts.SuperCartProductsPanel;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class SuperCartProductsController {

    SavedCart cart;
    List hCart;
    CartsWrapperController parent;
    SuperCartProductsPanel view;
    List<ShoppingItem> items;
    Model m = Model.getInstance();

    public SuperCartProductsController(SavedCart sCart, CartsWrapperController aParent,
            SuperCartProductsPanel aView) {
        this.cart = sCart;
        this.parent = aParent;
        this.view = aView;
        view.cartName.setText(cart.getName());
        view.priceLabel.setText("total kostnad " + (int) (cart.getTotalPrice()+0.5));
        items = cart.getItems();
        for (ShoppingItem si : items) {
            view.productsPanel.add(new CartProductPanel(si));
        }
    }

    public void hide() {
        parent.showAllCarts();
    }

    public void delete() {
        parent.delete(this.cart);
        m.removeSavedCartHistory(parent);
    }
    
    public List getCart(){
        return hCart;
    }

    public void addAll() {

        int a = 1;
        for (final ShoppingItem item : items) {
            Component[] list = view.productsPanel.getComponents();
            ProductImageLabel icon = null;
            for (Component c : list) {
                if (c instanceof CartProductPanel) {

                    CartProductPanel cpp = (CartProductPanel) c;
                    if (cpp.getShoppingItem().equals(item)) {
                        icon = cpp.icon;
                    }

                }
            }
            int locationx = icon.getLocationOnScreen().x;
            int locationy = icon.getLocationOnScreen().y;

            Point loc = IMatUtilities.getLocationRelativeToFrame(new Point(locationx, locationy));

            Rectangle from = new Rectangle(loc, icon.getBounds().getSize());
            Rectangle to = CartWithProductsPanelController.getImageBoundsOf(item.getProduct());
            for (int i = 1; i < item.getAmount() + 1; i++) {
                IMatUtilities.imageFlyAnimation(icon.getImage(), from, to, 80 * i * a, new TweenCallback() {

                    public void onEvent(EventType et, BaseTween bt) {
                        m.addToShoppingCart(item.getProduct(), 1);
                    }
                });
            }
            a++;
        }
    }
}

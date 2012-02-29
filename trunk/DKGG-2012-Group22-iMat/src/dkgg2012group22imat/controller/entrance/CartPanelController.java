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
import dkgg2012group22imat.view.entrance.carts.CartPanel;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartPanelController {

    SavedCart cart;
    CartPanel view;
    CartsPanelController parent;
    Model m = Model.getInstance();
    private List<ShoppingItem> items;
    private Dimension iconSize = new Dimension(60, 46);

    public CartPanelController(SavedCart sv, CartsPanelController aParent, CartPanel aView) {
        this.cart = sv;
        this.parent = aParent;
        this.view = aView;
        view.cartName.setText(sv.getName());
        items = sv.getItems();
        view.informationLabel.setText(items.size() + " varor för totalt " + (int) sv.getTotalPrice()+" kr");
        int amount = items.size() > 4 ? 4 : items.size();
        switch (amount) {
            case 4:
                view.icon4.setImage(m.getImageIcon(items.get(3).getProduct(), iconSize));
            case 3:
                view.icon3.setImage(m.getImageIcon(items.get(2).getProduct(), iconSize));
            case 2:
                view.icon2.setImage(m.getImageIcon(items.get(1).getProduct(), iconSize));
            case 1:
                view.icon1.setImage(m.getImageIcon(items.get(0).getProduct(), iconSize));
                break;
        }
    }

    public void addAll() {

        int a = 1;
        for (final ShoppingItem item : items) {
            ProductImageLabel icon = view.icon1;
            switch (a%4) {
                case 1:
                    icon = view.icon1;
                    break;
                case 2:
                    icon = view.icon2;
                    break;
                case 3:
                    icon = view.icon3;
                    break;
                case 4:
                    icon = view.icon4;
                    break;
            }
            int locationx = icon.getLocationOnScreen().x;
            int locationy = icon.getLocationOnScreen().y;

            

            Point loc = IMatUtilities.getLocationRelativeToFrame(new Point(locationx, locationy));
            
            Rectangle from = new Rectangle(loc, icon.getBounds().getSize());
            Rectangle to = CartWithProductsPanelController.getImageBoundsOf(item.getProduct());
            for (int i = 1; i < item.getAmount()+1; i++) {
                IMatUtilities.imageFlyAnimation(m.getImageIcon(item.getProduct(), new Dimension(120,106)).getImage(), from, to, 80 * i + 80 * a, new TweenCallback() {

                    public void onEvent(EventType et, BaseTween bt) {
                        m.addToShoppingCart(item.getProduct(), 1);
                    }
                });
            }
            a++;
        }
    }

    public void showThis() {
        parent.showCart(cart);
    }
}

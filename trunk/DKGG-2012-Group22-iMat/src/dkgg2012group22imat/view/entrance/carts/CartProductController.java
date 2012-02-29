/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view.entrance.carts;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenCallback.EventType;
import dkgg2012group22imat.controller.CartWithProductsPanelController;
import dkgg2012group22imat.model.IMatUtilities;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.DKGG2012Group22iMatApp;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import org.jdesktop.application.Application;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CartProductController {

    ShoppingItem item;
    CartProductPanel view;
    Model m = Model.getInstance();
    Dimension d = new Dimension(60, 53);

    public CartProductController(ShoppingItem si, CartProductPanel cartPanel) {
        this.item = si;
        this.view = cartPanel;
        view.icon.setImage(m.getImageIcon(si.getProduct(), new Dimension(d.width*2,d.height*2)));
        view.nameLabel.setText(si.getProduct().getName());
        view.informationLabel.setText((int) si.getAmount() + "st, totalt " + (int) si.getTotal() + "kr");
    }

    public void addItem() {

        int locationx = view.icon.getLocationOnScreen().x - ((DKGG2012Group22iMatApp) Application.getInstance()).getIMatView().getAnimationPanel().getLocationOnScreen().x;
        int locationy = view.icon.getLocationOnScreen().y - ((DKGG2012Group22iMatApp) Application.getInstance()).getIMatView().getAnimationPanel().getLocationOnScreen().y;
        Point loc = new Point(locationx, locationy);

        Rectangle from = new Rectangle(loc, view.icon.getBounds().getSize());
        Rectangle to = CartWithProductsPanelController.getImageBoundsOf(this.item.getProduct());

        for (int i = 0; i < this.item.getAmount(); i++) {
            IMatUtilities.imageFlyAnimation(view.icon.getImage(), from, to, 80 * i, new TweenCallback() {
                public void onEvent(EventType et, BaseTween bt) {
                    m.addToShoppingCart(item.getProduct(), 1);
                }
            });
        }
    }
}

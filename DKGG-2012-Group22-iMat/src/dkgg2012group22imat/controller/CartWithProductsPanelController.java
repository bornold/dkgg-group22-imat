/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartWithProductsPanel;

/**
 *
 * @author magnushuttu
 */
public class CartWithProductsPanelController {
    private CartWithProductsPanel cartProductView;
    private Model m = Model.getInstance();
    
    public CartWithProductsPanelController(CartWithProductsPanel cartProductView){
        this.cartProductView = cartProductView;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.CartPanel;

/**
 *
 * @author jonas
 */
public class CartPanelController {

    CartPanel view;
    Model m = Model.getInstance();

    public CartPanelController(CartPanel cartPanel) {
        this.view = cartPanel;
    }
}

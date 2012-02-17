/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.controller.checkout.CheckoutPanelController;
import dkgg2012group22imat.controller.entrance.EntrancePanelController;
import dkgg2012group22imat.controller.shop.ShopPanelController;
import dkgg2012group22imat.model.Model;

/**
 *
 * @author jonas
 */
public class MainPanelController {

    /*
     * State for what view is showing
     */
    public enum MainView {
        ENTRANCE,
        SHOP,
        CHECKOUT
    }

    //private varibles
    private MainView currentView = MainView.ENTRANCE;
    private Model m = Model.getInstance();
    private EntrancePanelController entrancePanelController = new EntrancePanelController();
    private ShopPanelController shopPanelController = new ShopPanelController();
    private CheckoutPanelController checkoutPanelController = new CheckoutPanelController();
    
    public MainPanelController() {
             
    }
    /*
     * getters and setters
     */
    public MainView getCurrentView() {
        return currentView;
    }
    public void setCurrentView(MainView currentView) {
        this.currentView = currentView;
    }
}

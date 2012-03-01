/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.controller.iMatViewController.MainView;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.DKGG2012Group22iMatApp;
import dkgg2012group22imat.view.DKGG2012Group22iMatView;
import dkgg2012group22imat.model.IMatUtilities;
import dkgg2012group22imat.view.MainButtonPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author jonas
 */
public class MainButtonPanelController implements ChangeListener {

    private MainButtonPanel view;
    private Model m = Model.getInstance();
    private MainView currentView;

    public MainButtonPanelController(MainButtonPanel view) {
        this.view = view;
        view.init();
        //this.currentView = IMatUtilities.getIMatViewController().getCurrentView();
        IMatUtilities.getIMatViewController().addChangeListener(this);
    }

    public void goTo(MainView viewEnum) {
        IMatUtilities.getIMatViewController().setCurrentView(viewEnum);
    }

    public void setView() {
        MainView handler = IMatUtilities.getIMatViewController().getCurrentView();
        if (handler != currentView) {
            currentView = handler;
            switch (handler) {
                case ENTRANCE:
                    view.mainTabCheckoutButton.setShadow(false);
                    view.mainTabShopButton.setShadow(false);
                    view.mainTabEntranceButton.setShadow(true);
                    
                    break;
                case SHOP:
                    view.mainTabCheckoutButton.setShadow(false);
                    view.mainTabShopButton.setShadow(true);
                    view.mainTabEntranceButton.setShadow(false);
                    break;
                case CHECKOUT:
                    view.mainTabCheckoutButton.setShadow(true);
                    view.mainTabShopButton.setShadow(false);
                    view.mainTabEntranceButton.setShadow(false);
                    break;
            }
        }
    }

    public void stateChanged(ChangeEvent ce) {
        if(ce.getSource() instanceof iMatViewController) {
            this.setView();
        }
    }

}
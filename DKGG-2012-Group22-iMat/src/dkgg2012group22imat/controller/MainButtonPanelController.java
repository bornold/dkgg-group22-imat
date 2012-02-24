/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.controller.iMatViewController.MainView;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.DKGG2012Group22iMatApp;
import dkgg2012group22imat.view.MainButtonPanel;

/**
 *
 * @author jonas
 */
public class MainButtonPanelController {

    private MainButtonPanel view;
    private Model m = Model.getInstance();

    public MainButtonPanelController(MainButtonPanel view) {
        this.view = view;
        
    }
    
    public void goTo(MainView viewEnum) {
       DKGG2012Group22iMatApp.getApplication().setView(viewEnum);
    }

}
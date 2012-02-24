/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.DKGG2012Group22iMatView;

/**
 *
 * @author jonas
 */
public class iMatViewController {

    /*
     * State for what view is showing
     */
    public enum MainView {
        ENTRANCE,
        SHOP,
        CHECKOUT
    }
    
    private DKGG2012Group22iMatView view;

    //private varibles
    private MainView currentView = MainView.ENTRANCE;
    private Model m = Model.getInstance();
    
    public iMatViewController(DKGG2012Group22iMatView view) {
        this.view = view;
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
    public void shutDown(){
        m.shutDown();
    }
    
    
}

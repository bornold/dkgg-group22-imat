/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.DKGG2012Group22iMatView;
import dkgg2012group22imat.view.IMatUtilities;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
    
    
    private Set<ChangeListener> listeners;
    
    private DKGG2012Group22iMatView view;

    //private varibles
    private static MainView currentView = MainView.ENTRANCE;
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
    public void setCurrentView(MainView newView) {
        currentView = newView;
        view.setView(newView);
        this.notifyChangeListeners();
    }
    public void shutDown(){
        m.shutDown();
    }
    
    public void addChangeListener(ChangeListener cl) {
        if(listeners == null) listeners = new HashSet();
        listeners.add(cl);
    }
    
    public void removeChangeListener(ChangeListener cl) {
        if(listeners != null)
        listeners.remove(cl);
    }
    
    private void notifyChangeListeners() {
        for(ChangeListener cl : listeners) {
            cl.stateChanged(new ChangeEvent(this));
        }
    }
    
    
}

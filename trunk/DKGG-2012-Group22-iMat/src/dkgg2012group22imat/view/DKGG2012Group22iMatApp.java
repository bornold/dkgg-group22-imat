/*
 * DKGG2012Group22iMatApp.java
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.controller.iMatViewController.MainView;
import dkgg2012group22imat.model.Model;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class DKGG2012Group22iMatApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override
    protected void startup() {
        Model.getInstance().reset();

        show(new DKGG2012Group22iMatView(this));
        DKGG2012Group22iMatView view = (DKGG2012Group22iMatView) this.getMainView();
        view.init();
        view.getController().setCurrentView(MainView.ENTRANCE);
        
    }

    @Override
    protected void shutdown() {
        Model.getInstance().shutDown();
        super.shutdown();
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of DKGG2012Group22iMatApp
     */
    public static DKGG2012Group22iMatApp getApplication() {
        return Application.getInstance(DKGG2012Group22iMatApp.class);
    }
    
    public DKGG2012Group22iMatView getIMatView() {
        if(this.getMainView() instanceof DKGG2012Group22iMatView)
            return (DKGG2012Group22iMatView)this.getMainView();
        return null;
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(DKGG2012Group22iMatApp.class, args);
    }
}

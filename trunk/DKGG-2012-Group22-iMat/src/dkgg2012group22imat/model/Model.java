/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.model;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;

/**
 * Wrapper around the IMatDataHandler. The idea is that it might be useful to add an extra layer
 * that can provide special features
 * 
 */
public class Model {

    private static Model instance = null;
    private IMatDataHandler iMatDataHandler;

    /**
     * Constructor that should never be called, use getInstance() instead.
     */
    protected Model() {
        // Exists only to defeat instantiation.
    }

    /**
     * Returns the single instance of the Model class.
     */
    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
            instance.init();
        }
        return instance;
    }

    private void init() {

        iMatDataHandler = IMatDataHandler.getInstance();

    }

    public Product getProduct(int idNbr) {
        return iMatDataHandler.getProduct(idNbr);
    }

    public ImageIcon getImageIcon(Product p, Dimension d) {
        return getImageIcon(p, d.width, d.height);
    }

    public ImageIcon getImageIcon(Product p, int width, int height) {
        return iMatDataHandler.getImageIcon(p, width, height);
    }

    public void addToShoppingCart(Product p) {
        ShoppingCart shoppingCart = iMatDataHandler.getShoppingCart();

        System.out.println("Buying: " + p.getName());

        shoppingCart.addProduct(p);
    }

    public Customer getCustomer() {
        return iMatDataHandler.getCustomer();
    }

    public ShoppingCart getShoppingCart() {
        return iMatDataHandler.getShoppingCart();
    }

    public void clearShoppingCart() {
        
        iMatDataHandler.getShoppingCart().clear();
        
    }
    
    public void placeOrder() {

      iMatDataHandler.placeOrder();
      
    }

    public int getNumberOfOrders() {

        return iMatDataHandler.getOrders().size();
        
    }
    
}
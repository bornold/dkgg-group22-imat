/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 * Wrapper around the IMatDataHandler. The idea is that it might be useful to add an extra layer
 * that can provide special features
 * 
 */
public class Model {

    private static Model instance = null;
    private IMatDataHandler iMatDataHandler;
    private List<SavedCart> savedCarts = new ArrayList<SavedCart>(); //TODO get Saved Carts

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
    private List _listeners = new ArrayList();

    public synchronized void addEventListener(FavoriteListener listener) {
        _listeners.add(listener);
    }

    public synchronized void removeEventListener(FavoriteListener listener) {
        _listeners.remove(listener);
    }

    // call this method whenever you want to notify
    //the event listeners of the particular event
    private synchronized void fireFavoriteEvent() {
        FavoriteEvent event = new FavoriteEvent(this);
        for (int i = 0; i < _listeners.size(); i++) {
            ((FavoriteListener) _listeners.get(i)).handleFavoriteEvent(event);
        }
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

    public void addToShoppingCart(Product p, int amount) {
        for (int i = 0; i < amount; i++) {
            addToShoppingCart(p);
        }
    }

    public void addToShoppingCart(Product p) {
        ShoppingCart shoppingCart = iMatDataHandler.getShoppingCart();
        System.out.println("CartAdding: " + p.getName());
        shoppingCart.addProduct(p);
    }

    public void addToShoppingCart(ShoppingItem si) {
        addToShoppingCart(si.getProduct(), (int)si.getAmount()); 
    }

     public void addToShoppingCart(List <ShoppingItem> items) {
        for(ShoppingItem si : items){
            addToShoppingCart(si);
        }
    }
    
    public void removeFromShoppingCart(Product p) {
        ShoppingCart shoppingCart = iMatDataHandler.getShoppingCart();
        System.out.println("CartRemoving: " + p.getName());
        shoppingCart.removeProduct(p);
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
        //TODO add products in a map with key product and value an int with times bought, use it later to rank the result
        iMatDataHandler.placeOrder();
    }

    public int getNumberOfOrders() {
        return iMatDataHandler.getOrders().size();
    }

    /**
     *  Latest offers
     * @return A list of products that is on sale.
     */
    public List getOffers() {
        return getRandomProducts();
    }

    public List getFavorites() {
        return iMatDataHandler.favorites();
    }

    public void addFavorite(Product p) {
        iMatDataHandler.addFavorite(p.getProductId());
        fireFavoriteEvent();
    }

    public void removeFavorite(Product p) {
        iMatDataHandler.removeFavorite(p);
        fireFavoriteEvent();
    }

    public boolean isFavorite(Product p) {
        return iMatDataHandler.isFavorite(p);
    }

    public int shutDown() {
        iMatDataHandler.shutDown();
        return 3;
    }

    public List getHistoryCarts() {
        return iMatDataHandler.getOrders();
    }

    public List<Order> getOrders() {
        return iMatDataHandler.getOrders();
    }
    
    public List<SavedCart> getSavedCarts() {
        return savedCarts;
    }

    public void saveNewCart(List<ShoppingItem> cart, String name) {
        savedCarts.add(new SavedCart(cart, name));
    }

    public void removeSavedCart(SavedCart cart) {
        this.savedCarts.remove(cart);
    }
   
    public void reset() {
        iMatDataHandler.reset();
    }

    private List getRandomProducts() {
        List l = iMatDataHandler.getProducts();
        Random generator = new Random();
        while (l.size() > 6) {
            l.remove(generator.nextInt(l.size()));
        }
        return l;
    }
}
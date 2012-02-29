/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.model;
//
//TODO TOOL TIPS ALL THE BUTTONS
//
//TODO Request focus på sparad kundvagn + add actionPreformed på textfielden
//
//TODO Ta bort favoriteListener från cartProductsen
//
//TODO Kundvagns pris till närmaste 50 öring alternativt 10 öring (ex: 44,50kr 64,00);
//
//TODO -Till kassa knappen på kundvagnen bytas ut/inaktiveras/tas bort i kassan
//
//---Tveksamma saker, extra 
//TODO Input Hints s.364 eller Input Promt s.369 i kassa
//
//TODO favoritvara syns alltid gul stjärna på
//
//TODO (Tveksamm) Mindre ProductPaneler?
//
//TODO (Tveksamm) Resize på ProductPaneler?
//
//TODO (Tveksamm) Spara kundvagnknapp längst upp?
//
//TODO (Tveksamm)Töm kundvagn knapp?
//
//TODO (Tveksamm) Skriva text i tomma kundvagnen, favoritprodukter, gamla/sparade kundvagnar?
//
//TODO (Tveksamm) First run? Gå till butik knapp på entré?
//
//TODO (Tveksamm) Göm scrollbar i kundvagn och panelerna när de inte behövs

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dkgg2012group22imat.controller.entrance.CartsWrapperController;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Order;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;
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
    //TODO get Saved Carts
    private List<SavedCart> savedCarts = new ArrayList<SavedCart>();

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
        readSavedCartFile();
    }
    private List favouriteListeners = new ArrayList();

    public synchronized void addFavouriteEventListener(FavoriteListener listener) {
        favouriteListeners.add(listener);
//        System.out.println("FavouriteEventListener: " + favouriteListeners.size());
    }

    public synchronized void removeFavouriteEventListener(FavoriteListener listener) {
        favouriteListeners.remove(listener);
    }
    private List savedCartListeners = new ArrayList();

    public synchronized void addSavedCartEventListener(SavedCartListener listener) {
        savedCartListeners.add(listener);
//        System.out.println("SavedCartsListeners: " + savedCartListeners.size());
    }

    public synchronized void removeSavedCartEventListener(SavedCartListener listener) {
        savedCartListeners.remove(listener);
    }

    // call this method whenever you want to notify
    //the event listeners of the particular event
    private synchronized void fireFavoriteEvent() {
        FavoriteEvent event = new FavoriteEvent(this);
        for (int i = 0; i < favouriteListeners.size(); i++) {
            ((FavoriteListener) favouriteListeners.get(i)).handleFavoriteEvent(event);
        }
    }

    private synchronized void fireSavedCartEvent() {
        SavedCartEvent event = new SavedCartEvent(this);
        for (int i = 0; i < savedCartListeners.size(); i++) {
            ((SavedCartListener) savedCartListeners.get(i)).onSavedCartEvent(event);
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

    public void addToShoppingCart(Product p, double amount) {

        ShoppingCart shoppingCart = iMatDataHandler.getShoppingCart();
        System.out.println("CartAdding: " + p.getName());
        List<ShoppingItem> list = shoppingCart.getItems();
        boolean shoppingCartUpdated = false;
        for (ShoppingItem item : list) {
            if (item.getProduct() == p) {
                item.setAmount(item.getAmount() + amount);
                shoppingCartUpdated = true;
            }
        }
        if (shoppingCartUpdated) {
            shoppingCart.fireShoppingCartChanged();
        } else {
            shoppingCart.addItem(new ShoppingItem(p, amount));
        }
    }

    public void addToShoppingCart(Product p) {
        addToShoppingCart(p, 1);
    }

    public void addToShoppingCart(ShoppingItem si) {
        addToShoppingCart(si.getProduct(), si.getAmount());
    }

    public void addToShoppingCart(List<ShoppingItem> items) {
        for (ShoppingItem si : items) {
            addToShoppingCart(si);
        }
    }

    public void removeFromShoppingCart(Product p) {
        ShoppingCart shoppingCart = iMatDataHandler.getShoppingCart();
        System.out.println("CartRemoving: " + p.getName());
        shoppingCart.removeProduct(p);
    }

    public void removeFromShoppingCart(ShoppingItem si) {
        iMatDataHandler.getShoppingCart().removeItem(si);

    }

    public Customer getCustomer() {
        return iMatDataHandler.getCustomer();
    }

    public CreditCard getCreditCard() {
        return iMatDataHandler.getCreditCard();
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
    public List<Product> getOffers() {
        return getRandomProducts();
    }

    public List<Product> getFavorites() {
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

    public void shutDown() {
        writeSavedCartsFile();
        iMatDataHandler.getShoppingCart().clear();
        iMatDataHandler.shutDown();
    }

    public List getHistoryCarts() {
        return iMatDataHandler.getOrders();
    }

    public List<Order> getOrders() {
        return iMatDataHandler.getOrders();
    }

    public List<SavedCart> getSavedCartHistory() {//TODO: Kolla på att ta bort bättre
        List<Order> orders = getOrders();
        List<SavedCart> historySavedCarts = new ArrayList<SavedCart>();
        //TODO make getDate().toString() better.
        for (Order o : orders) {
            Date d = o.getDate();
            String day = d.getDay()<10 ? "0"+d.getDay():""+d.getDay();
            String month = d.getMonth()<10 ? "0"+d.getMonth():""+d.getMonth();
            String year = ""+(d.getYear()+1900);
            String name = ""+day +"-"+ month +"-"+ year;
            historySavedCarts.add(new SavedCart(o.getItems(), name));
        }
        return historySavedCarts;
    }
    
    public void removeSavedCartHistory(CartsWrapperController parent, SavedCart cart){
        getOrders().clear();
        parent.showAllCarts();
    }

    public List<SavedCart> getSavedCarts() {
        return savedCarts;
    }

    public SavedCart getSavedCart(String name) {
        Iterator<SavedCart> it = this.getSavedCarts().iterator();
        while (it.hasNext()) {
            SavedCart savedCart = it.next();
            if (savedCart.getName().equals(name)) {
                return savedCart;
            }
        }
        return null;
    }

    @Deprecated
    public void saveNewCart(List<ShoppingItem> cart, String name) {
        System.out.println("Saved new Shoppingcart " + name);
        savedCarts.add(new SavedCart(cart, name));
        this.fireSavedCartEvent();
    }

    public synchronized void saveCart(List<ShoppingItem> cart, String name) {
        System.out.println("Saved new Shoppingcart " + name);
        for (SavedCart savedCart : this.getSavedCarts()) {
            if (savedCart.getName().equals(name)) {
                savedCarts.remove(savedCart);
            }
        }
        savedCarts.add(new SavedCart(cart, name));
        this.fireSavedCartEvent();
    }

    public void removeSavedCart(SavedCart cart) {
        this.savedCarts.remove(cart);
    }

//    public void reset() {
//        iMatDataHandler.reset();
//    }
    public List<Product> getProducts(Category c) {
        List<Product> returnList = new ArrayList();

        if (c.getProductCategory() != null) {
            returnList.addAll(this.getProducts(c.getProductCategory()));
        }

        if (c.getSubCategories().size() > 0) {
            for (Category sub : c.getSubCategories()) {
                returnList.addAll(this.getProducts(sub));
            }
        }

        return returnList;
    }

    public List<Product> getProducts(ProductCategory pc) {
        return iMatDataHandler.getProducts(pc);
    }

    public List<Product> getProducts() {
        return iMatDataHandler.getProducts();
    }

    public List<Product> search(String searchString) {
        return iMatDataHandler.findProducts(searchString);
    }

    private List<Product> getRandomProducts() {
        List<Product> l = new ArrayList();
        l.addAll(getProducts());
        Random generator = new Random();
        while (l.size() > 6) {
            l.remove(generator.nextInt(l.size()));
        }
        return l;
    }

    public List<Category> getCategories() {

        //ResourceMap resourceMap = Application.getInstance(DKGG2012Group22iMatApp.class).getContext().getResourceMap(CategoriesController.class);

        try {
            InputStream in = this.getClass().getResourceAsStream("categories.json");
            InputStreamReader isr = new InputStreamReader(in, "utf-8");
            BufferedReader br =
                    new BufferedReader(isr);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }

            pw.close();
            //System.out.println(sw.toString());

            Gson gson = new Gson();
            Type type = new TypeToken<List<Category>>() {
            }.getType();
            List<Category> result = gson.fromJson(sw.toString(), type);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeSavedCartsFile() {
        Gson gson = new Gson();

        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(savedCarts);

        try {
            //write converted json data to a file named "file.json"
            FileWriter writer = new FileWriter(new File(this.getSettingsDirectory().getPath() + "/carts.json"));
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readSavedCartFile() {
        try {
            /*InputStream in = this.getClass().getResourceAsStream("./carts.json");
            InputStreamReader isr = new InputStreamReader(in, "utf-8");*/
            FileReader fr = new FileReader(new File(this.getSettingsDirectory().getPath() + "/carts.json"));
            BufferedReader br =
                    new BufferedReader(fr);
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
            }

            pw.close();
            //System.out.println(sw.toString());

            Gson gson = new Gson();
            Type type = new TypeToken<List<SavedCart>>() {
            }.getType();
            savedCarts = gson.fromJson(sw.toString(), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getSettingsDirectory() {
        String userHome = System.getProperty("user.home");
        if (userHome == null) {
            throw new IllegalStateException("user.home==null");
        }
        File home = new File(userHome);
        File settingsDirectory = new File(home, ".dat215/imat/");
        if (!settingsDirectory.exists()) {
            if (!settingsDirectory.mkdir()) {
                throw new IllegalStateException(settingsDirectory.toString());
            }
        }
        return settingsDirectory;
    }
}

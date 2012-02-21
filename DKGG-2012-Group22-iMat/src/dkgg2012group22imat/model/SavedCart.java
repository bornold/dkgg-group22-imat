/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.model;

import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class SavedCart {
   private List<ShoppingItem> cart = new ArrayList<ShoppingItem>();
   private String name;
   private double totalPrice;
   public SavedCart(List<ShoppingItem> cart, String name) {
       this.cart = cart;
       this.name = name;
   }
      public SavedCart( String name) {
       this.name = name;
   }
      public void add(ShoppingItem si) {
          cart.add(si);
      }
}

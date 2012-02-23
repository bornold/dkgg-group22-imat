/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.model;

import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class SavedCart {
   private List<ShoppingItem> items = new ArrayList<ShoppingItem>();
   private String name;
   public SavedCart(List<ShoppingItem> cart, String name) {
       this.items = cart;
       this.name = name;
   }
      public void add(ShoppingItem si) {
          items.add(si);
      }
      public void addAll(List<ShoppingItem> si) {
          items.addAll(si);
      }
      public void remove(ShoppingItem si){
          items.remove(si);
      }
      public void remove(Product p){
          for (ShoppingItem si : items) {
              if (si.getProduct().equals(p)){
                  items.remove(si);
              }
          }
      }
      public List<ShoppingItem> getItems() {
          return items;
      }
      public double getTotalPrice() {
          double tot = 0;
          for(ShoppingItem si : items) {
              tot += si.getProduct().getPrice() * si.getAmount();
          }
          return tot;
      }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
         
}

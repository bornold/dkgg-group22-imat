/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.shop.CategoriesPanel;
import dkgg2012group22imat.view.shop.CategoryPanel;
import java.util.Iterator;
import java.util.List;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author jonas
 */
public class CategoriesController {

    Model m = Model.getInstance();
    List<Category> categories;
    CategoriesPanel view;

    public CategoriesController(CategoriesPanel cp) {
        this.categories = m.getCategories();
        this.view = cp;
        System.out.println("Total top categories "+categories.size());
        Iterator<Category> it = categories.iterator();
        System.out.println("iterator "+it);
        while(it.hasNext()) {
            
            Category c = it.next();
            
            view.getCategoryListPanel().add(new CategoryPanel(c));
            
            System.out.println(c.getName());
            System.out.println(c.getHandler());
            System.out.println(c.getSubCategories());
            
        }
        
    }

    public void showFavorites() {
        //TODO fill in
    }

    public void showSearch() {
        //TODO fill in
    }

    public void showItems(ProductCategory pc) {
        //TODO fill in
    }
}

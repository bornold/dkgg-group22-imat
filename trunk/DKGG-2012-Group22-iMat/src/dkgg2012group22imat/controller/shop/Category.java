/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author Simon
 */
public class Category {
    
    private String name;
    private String handler;
    private List<Category> subs;
    
    public Category(String name, String handler, List<Category> subs) {
        this.name = name;
        this.handler = handler;
        this.subs = subs;
    }
    
    public String getName() {
        return name;
    }
    
    public String getHandler() {
        return handler;
    }
    
    public ProductCategory getProductCategory() {
        return ProductCategory.valueOf(handler);
    }
    
    public List<Category> getSubCategories() {
        if(subs != null)
            return subs;//WARNING returns inner object.
        else
            return new ArrayList<Category>();
    }
}

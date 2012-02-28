/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Category;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.shop.CategoryPanel;
import java.awt.Color;

/**
 *
 * @author Simon
 */
public class CategoryPanelController {

    Model m = Model.getInstance();
    CategoryPanel view;
    Category category;
    CategoriesController parent;

    public CategoryPanelController(CategoriesController parent, CategoryPanel view) {
        this.view = view;
        this.category = view.getCategory();
        this.view.getCategoryButton().setText(category.getName());
        this.parent = parent;
        
        view.updateState();
        
        if(this.category.getSubCategories().size()>0) {
            for(Category c : this.category.getSubCategories()) {
                this.view.getSubCategoriesPanel().add(new CategoryPanel(parent, c,(this.view.getLevel()+2)));
            }
            this.view.revalidate();
            this.view.repaint();
        }
        
    }
    
    public void open() {
        if(this.category.getSubCategories().size()>0) {
            view.showSubCategories();
        }
        view.setActive(true,false);
        parent.openCategory(this.category);
        //view.updateState();
    }
    public void close() {
        view.hideSubCategories();
        view.setActive(false,false);
        
    }
    
    
}

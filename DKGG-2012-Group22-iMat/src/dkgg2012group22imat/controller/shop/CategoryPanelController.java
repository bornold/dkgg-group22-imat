/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.shop.CategoryPanel;

/**
 *
 * @author Simon
 */
public class CategoryPanelController {

    Model m = Model.getInstance();
    CategoryPanel view;
    Category category;

    public CategoryPanelController(CategoryPanel view) {
        this.view = view;
        this.category = view.getCategory();
        this.view.getCategoryButton().setText(category.getName());
        
    }
    
    public void open() {
        this.expand();
        //TODO update view.
    }
    
    private void expand() {
        if(this.category.getSubCategories().size()>0) {
            for(Category c : this.category.getSubCategories()) {
                this.view.getSubCategoriesPanel().add(new CategoryPanel(c,view.getLevel()+1));
            }
            this.view.revalidate();
            this.view.repaint();
        }
    }
    
    private void contract() {
        this.view.getSubCategoriesPanel().removeAll();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

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

    public CategoryPanelController(CategoryPanel view) {
        this.view = view;
        this.category = view.getCategory();
        this.view.getCategoryButton().setText(category.getName());
        
        view.hideSubCategories();
        
        if(this.category.getSubCategories().size()>0) {
            for(Category c : this.category.getSubCategories()) {
                this.view.getSubCategoriesPanel().add(new CategoryPanel(c,(this.view.getLevel()+2)));
            }
            this.view.revalidate();
            this.view.repaint();
        }
        
    }
    
    public void open() {
        if(this.category.getSubCategories().size()>0) {
            this.expand();
        }
        
        this.view.getCategoryButton().setEnabled(false);
        this.view.getCategoryButton().setText("<html><font color=white>"+this.view.getCategoryButton().getText()+"</font></html>");
        //TODO update view.
    }
    public void close() {
        if(this.category.getSubCategories().size()>0) {
            this.contract();
        }
        this.view.getCategoryButton().setEnabled(true);
        this.view.getCategoryButton().setText(this.view.getCategoryButton().getText());
        
    }
    
    private void expand() {
        view.showSubCategories();
        
    }
    
    private void contract() {
        view.hideSubCategories();
        
    }
    
}

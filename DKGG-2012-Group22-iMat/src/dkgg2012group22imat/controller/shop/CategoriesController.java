/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Category;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.shop.CategoriesPanel;
import dkgg2012group22imat.view.shop.CategoryPanel;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jonas
 */
public class CategoriesController {

    Model m = Model.getInstance();
    List<Category> categories;
    List<CategoryPanel> categoryPanels;
    CategoriesPanel view;
    ShopPanelController parent;

    public CategoriesController(ShopPanelController parent, CategoriesPanel cp) {
        this.parent = parent;
        this.categories = m.getCategories();
        this.view = cp;
        this.categoryPanels = new ArrayList();
        System.out.println("Total top categories " + categories.size());
        for (Category cat : categories) {
            CategoryPanel categoryPanel = new CategoryPanel(this, cat);
            categoryPanels.add(categoryPanel);
            view.getCategoryListPanel().add(categoryPanel);

            System.out.println(cat.getName());
            System.out.println(cat.getHandler());
            System.out.println(cat.getSubCategories());

        }

    }

    public void showFavorites() {
        //TODO fill in
    }

    public void showSearch() {
        //TODO fill in
    }

    public void openCategory(Category c) {
        parent.showCategory(c);

        this.setButtons(this.categoryPanels, c);
    }

    private void setButtons(List<CategoryPanel> categoryPanels, Category c) {

        for (CategoryPanel categoryPanel : categoryPanels) {

            if (categoryPanel.getCategory() == c && categoryPanel.getCategory().contains(c)) {
                categoryPanel.setActive(true, false);
            } else if (categoryPanel.getCategory().contains(c)) {
                categoryPanel.setActive(true, true);
            } else {
                categoryPanel.setActive(false, false);
            }

            if (categoryPanel.getSubCategoriesPanel().getComponents().length > 0) {
                List<CategoryPanel> list = new ArrayList();
                for (Component component : categoryPanel.getSubCategoriesPanel().getComponents()) {
                    if (component instanceof CategoryPanel) {
                        list.add((CategoryPanel) component);
                    }
                }
                if (list.size() > 0) {
                    this.setButtons(list, c);
                }
            }
        }
    }
}

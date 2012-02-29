/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Category;
import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.shop.CategoriesPanel;
import dkgg2012group22imat.view.shop.CategoryPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

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
    JButton searchButton;
    JButton favoritesButton;
    JButton allButton;

    public CategoriesController(ShopPanelController parent, CategoriesPanel cp) {
        this.parent = parent;
        this.categories = m.getCategories();
        this.view = cp;
        this.categoryPanels = new ArrayList();
        System.out.println("Total top categories " + categories.size());

        this.view.getCategoryListPanel().add(this.createAllButton());
        
        for (Category cat : categories) {
            CategoryPanel categoryPanel = new CategoryPanel(this, cat);
            categoryPanels.add(categoryPanel);
            view.getCategoryListPanel().add(categoryPanel);

        }

        this.view.getCategoryListPanel().add(this.createFavoritesButton());
        this.view.getCategoryListPanel().add(this.createSearchButton());
    }

    private JPanel createAllButton() {
        JPanel jp = new JPanel();
        final JButton button = new JButton();
        final org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CategoryPanel.class);

        button.setBackground(resourceMap.getColor("categoryButton.background")); // NOI18N
        button.setFont(resourceMap.getFont("categoryButton.font")); // NOI18N
        button.setForeground(resourceMap.getColor("categoryButton.foreground")); // NOI18N

        button.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("categoryButton.border.lineColor"))); // NOI18N
//        button.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY, 0));
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button.setMaximumSize(new java.awt.Dimension(248, 28));
        button.setMinimumSize(new java.awt.Dimension(0, 28));
        button.setName("categoryButton"); // NOI18N
        button.setOpaque(true);
        button.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(resourceMap.getColor("categoryButton.foreground")); // NOI18N
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(255, 255, 255)); // NOI18N
            }
        });
        button.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAll();
            }
        });

        button.setIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_all.png")));
        button.setPressedIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_all_active.png"))); // NOI18N
        button.setRolloverIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_all_hover.png"))); // NOI18N
        button.setDisabledIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_all_active.png"))); // NOI18N
//        button.setDisabledSelectedIcon(resourceMap.getIcon("categoryButton.disabledSelectedIcon")); // NOI18N
        button.setText("");
        jp.setLayout(new java.awt.BorderLayout());
        jp.add(button, BorderLayout.NORTH);
        this.allButton = button;
        return jp;
    }
    private JPanel createSearchButton() {
        JPanel jp = new JPanel();
        final JButton button = new JButton();
        final org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CategoryPanel.class);

        button.setBackground(resourceMap.getColor("categoryButton.background")); // NOI18N
        button.setFont(resourceMap.getFont("categoryButton.font")); // NOI18N
        button.setForeground(resourceMap.getColor("categoryButton.foreground")); // NOI18N

        button.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("categoryButton.border.lineColor"))); // NOI18N
//        button.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY, 0));
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button.setMaximumSize(new java.awt.Dimension(248, 28));
        button.setMinimumSize(new java.awt.Dimension(0, 28));
        button.setName("categoryButton"); // NOI18N
        button.setOpaque(true);
        button.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(resourceMap.getColor("categoryButton.foreground")); // NOI18N
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(255, 255, 255)); // NOI18N
            }
        });
        button.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showSearch();
            }
        });

        button.setIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_sok.png")));
        button.setPressedIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_sok_active.png"))); // NOI18N
        button.setRolloverIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_sok_hover.png"))); // NOI18N
        button.setDisabledIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_sok_active.png"))); // NOI18N
//        button.setDisabledSelectedIcon(resourceMap.getIcon("categoryButton.disabledSelectedIcon")); // NOI18N
        button.setText("");
        jp.setLayout(new java.awt.BorderLayout());
        jp.add(button, BorderLayout.NORTH);
        this.searchButton = button;
        return jp;
    }

    private JPanel createFavoritesButton() {
        JPanel jp = new JPanel();
        final JButton button = new JButton();
        final org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CategoryPanel.class);

        button.setBackground(resourceMap.getColor("categoryButton.background")); // NOI18N
        button.setFont(resourceMap.getFont("categoryButton.font")); // NOI18N
        button.setForeground(resourceMap.getColor("categoryButton.foreground")); // NOI18N

        button.setBorder(javax.swing.BorderFactory.createLineBorder(resourceMap.getColor("categoryButton.border.lineColor"))); // NOI18N
//        button.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY, 0));
        button.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button.setMargin(new java.awt.Insets(0, 0, 0, 0));
        button.setMaximumSize(new java.awt.Dimension(248, 28));
        button.setMinimumSize(new java.awt.Dimension(0, 28));
        button.setName("categoryButton"); // NOI18N
        button.setOpaque(true);
        button.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(resourceMap.getColor("categoryButton.foreground")); // NOI18N
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(255, 255, 255)); // NOI18N
            }
        });
        button.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showFavorites();
            }
        });

        button.setIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_favorites.png")));
        button.setPressedIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_favorites_active.png"))); // NOI18N
        button.setRolloverIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_favorites_hover.png"))); // NOI18N
        button.setDisabledIcon(new ImageIcon(this.getClass().getResource("/dkgg2012group22imat/resources/gradient_category_favorites_active.png"))); // NOI18N
//        button.setDisabledSelectedIcon(resourceMap.getIcon("categoryButton.disabledSelectedIcon")); // NOI18N
        button.setText("");
        jp.setLayout(new java.awt.BorderLayout());
        jp.add(button, BorderLayout.NORTH);
        this.favoritesButton = button;
        return jp;
    }

    public void showFavorites() {
        parent.showFavorites();
        this.favoritesButton.setEnabled(false);
        this.searchButton.setEnabled(true);
        this.allButton.setEnabled(true);
        setButtons(categoryPanels, null);
    }

    public void showSearch() {
        parent.showSearch();
        this.searchButton.setEnabled(false);
        this.favoritesButton.setEnabled(true);
        this.allButton.setEnabled(true);
        setButtons(categoryPanels, null);
    }
    
    public void showAll() {
        parent.showAll();
        this.searchButton.setEnabled(true);
        this.favoritesButton.setEnabled(true);
        this.allButton.setEnabled(false);
        setButtons(categoryPanels, null);
    }

    public void openCategory(Category c) {
        parent.showCategory(c);
        this.searchButton.setEnabled(true);
        this.favoritesButton.setEnabled(true);
        this.allButton.setEnabled(true);
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

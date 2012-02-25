/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductPanel;
import dkgg2012group22imat.view.ProductsPanel;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class ProductsPanelController {

    protected Model m = Model.getInstance();
    private List<Product> items;
    private List<List<Product>> pageList = new ArrayList<List<Product>>();
    private ProductsPanel view;
    private int productsOnScreen;
    protected int currentPage = 0;
    private int nrOfPages;
    //TODO HTML manipulate current view
    private String navigationChart[][][] = {
        {
            {""}
        },
        {
            {"1 2"},
            {"1 2"}
        },
        {
            {"1 2 3"},
            {"1 2 3"},
            {"1 2 3"}
        },
        {
            {"1 2 3 4"},
            {"1 2 3 4"},
            {"1 2 3 4"},
            {"1 2 3 4"}
        },
        {
            {"1 2 3 4 5"},
            {"1 2 3 4 5"},
            {"1 2 3 4 5"},
            {"1 2 3 4 5"},
            {"1 2 3 4 5"}
        },
        {
            {"1 2 3 4 5 6"},
            {"1 2 3 4 5 6"},
            {"1 2 3 4 5 6"},
            {"1 2 3 4 5 6"},
            {"1 2 3 4 5 6"},
            {"1 2 3 4 5 6"}
        },
        {
            {"1 2 3 4 5 6 7"},
            {"1 2 3 4 5 6 7"},
            {"1 2 3 4 5 6 7"},
            {"1 2 3 4 5 6 7"},
            {"1 2 3 4 5 6 7"},
            {"1 2 3 4 5 6 7"},
            {"1 2 3 4 5 6 7"}
        }
    };

    public ProductsPanelController(List<Product> prods, int amount, ProductsPanel panel) {
        this.view = panel;
        this.productsOnScreen = amount;

        setList(prods);
    }

    public void viewNextProducts() {
        if (currentPage + 1 < nrOfPages) {
            viewPage(currentPage + 1);
        }
    }

    public void viewPrevProducts() {
        if (currentPage - 1 >= 0) {
            viewPage(currentPage - 1);
        }
    }

    private void viewPage(int page) {
        view.productPanel.removeAll();
        for (Product p : pageList.get(page)) {
            view.productPanel.add(new ProductPanel(p));
        }
        currentPage = page;
        setNavigation();
        view.updateUI();
    }

    private void setNavigation() {
        //TODO change to view.navigationLabel.setText(navigationChart[0][nrOfPages][currentPage]);

        if (nrOfPages <= 1) {
            view.productPanel.setVisible(false);
            view.backButton.setVisible(false);
            view.forwardButton.setVisible(false);
            view.navigationLabel.setVisible(false);
        } else {
            view.navigationLabel.setText("Visar sida " + (currentPage + 1) + 
                    " av " + nrOfPages);
            view.productPanel.setVisible(true);
            if (currentPage == 0) {
                view.backButton.setVisible(false);
            } else {
                view.backButton.setVisible(true);
            }
            if (currentPage == (nrOfPages - 1)) {
                view.forwardButton.setVisible(false);
            } else {
                view.forwardButton.setVisible(true);
            }
        }
    }

    public final void setList(List<Product> prods) {
        if (prods.size() > 0) {
            this.items = prods;
            for (int front = 0, end = productsOnScreen; // sublist bounds 
                    end <= items.size();
                    front += productsOnScreen, end += productsOnScreen) {
                pageList.add(items.subList(front, end));

            }
            nrOfPages = (items.size() / productsOnScreen);

            if (items.size() % productsOnScreen != 0 && items.size() != 1) {
                pageList.add(items.subList(nrOfPages * productsOnScreen, items.size()));
                nrOfPages++;
            } else if (items.size() == 1) {
                nrOfPages = 0;
                List l = new ArrayList<Product>();
                l.add(items.get(items.size() - 1));
                pageList.add(l);
            }
            viewPage(currentPage);
        } else {
            nrOfPages = 0;
            setNavigation();
        }
    }
}
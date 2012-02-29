/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.PagenationButton;
import dkgg2012group22imat.view.ProductPanel;
import dkgg2012group22imat.view.ProductsPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class ProductsPanelController {

    private final int productWidth = 210;
    private final int productHeight = 230;
    protected Model m = Model.getInstance();
    private List<Product> items;
    private List<List<Product>> pageList = new ArrayList<List<Product>>();
    private ProductsPanel view;
    private int productsOnScreen = 1;
    protected int currentPage = 0;
    private int nrOfPages;

    @Deprecated
    public ProductsPanelController(List<Product> prods, int amount, ProductsPanel panel) {
        this.view = panel;
        this.productsOnScreen = amount;
        setList(prods);
    }

    public ProductsPanelController(List<Product> prods, ProductsPanel panel) {
        this.view = panel;
        productsOnScreen = productsPerPage();

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

    public void goToPage(int page) {
        viewPage(page);
    }

    private void viewPage(int page) {
        Component[] list = view.productPanel.getComponents();
        for (Component c : list) {
            if (c instanceof ProductPanel) {
                ProductPanel pp = (ProductPanel) c;
                pp.getController().remove();
            }
        }
        view.productPanel.removeAll();
        if (page < pageList.size()) {
            currentPage = page;
        } else {
            currentPage = pageList.size() - 1;
        }
        for (Product p : pageList.get(currentPage)) {
            view.productPanel.add(new ProductPanel(p));
        }
        setNavigation();
        view.updateUI();
    }

    private void setNavigation() {
        if (nrOfPages < 0) {
            view.productPanel.setVisible(false);
            view.backButton.setVisible(false);
            view.forwardButton.setVisible(false);

        } else {
            view.pagenationPanel.removeAll();
            int lowerBound = 0;
            int upperBound = nrOfPages;
            if (nrOfPages >= 8) {
                if (currentPage > 4) {
                    if (currentPage + 4 > nrOfPages) {
                        lowerBound = nrOfPages - 7;
                        upperBound = nrOfPages;
                    } else {
                        lowerBound = currentPage - 3;
                        upperBound = currentPage + 4;
                    }
                } else {
                    lowerBound = 0;
                    upperBound = 8;
                }
            }
            for (int i = lowerBound; i < upperBound; i++) {
                if (i == currentPage) {
                    PagenationButton pb = new PagenationButton(i, this);
                    pb.setEnabled(false);
                    view.pagenationPanel.add(pb);
                } else {
                    view.pagenationPanel.add(new PagenationButton(i, this));
                }
            }
            view.productPanel.setVisible(true);
            if (currentPage == 0) {
//                view.backButton.setVisible(false);
                view.backButton.setEnabled(false);
//                view.backButton.setBorderPainted(false);
            } else {
//                view.backButton.setVisible(true);
                view.backButton.setEnabled(true);
//                view.backButton.setBorderPainted(true);
            }
            if (currentPage == (nrOfPages - 1)) {
//                view.forwardButton.setVisible(false);
                view.forwardButton.setEnabled(false);
//                view.forwardButton.setBorderPainted(false);
            } else {
//                view.forwardButton.setVisible(true);
                view.forwardButton.setEnabled(true);
//                view.forwardButton.setBorderPainted(true);
            }
        }
    }

    public final void setList(List<Product> prods) {
        pageList = new ArrayList<List<Product>>();
        if (prods != null) {
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
                    nrOfPages = 1;
                    List l = new ArrayList<Product>();
                    l.add(items.get(items.size() - 1));
                    pageList.add(l);
                }
                viewPage(currentPage);
            } else {
                nrOfPages = -1;
                setNavigation();
            }
        }
    }

    public final int productsPerPage() {
        Dimension panelDimension = view.productPanel.getSize();
        int produkterBredd = ((panelDimension.width / productWidth) > 1)
                ? (panelDimension.width / productWidth) : 1;
        int produkterHöjd = ((panelDimension.height / productHeight) > 1)
                ? (panelDimension.height / productHeight) : 1;
        return produkterBredd * produkterHöjd;
    }

    public void reSized() {
        int ppp = productsPerPage();
        if (ppp != productsOnScreen) {
            productsOnScreen = ppp;
            setList(items);
        }
    }
}

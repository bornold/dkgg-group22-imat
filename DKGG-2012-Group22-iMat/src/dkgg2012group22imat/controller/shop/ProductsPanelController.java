/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.view.shop.ProductsPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class ProductsPanelController {
    private ProductsPanel view;
    private List<Product> products;
    
    public ProductsPanelController(ProductsPanel view, List<Product> products) {
        this.view = view;
        this.products = products;
    }
    
}
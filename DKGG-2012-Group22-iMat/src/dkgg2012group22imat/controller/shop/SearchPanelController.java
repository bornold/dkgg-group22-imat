/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.shop;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.ProductsPanel;
import dkgg2012group22imat.view.shop.SearchPanel;
import java.util.List;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author jonas
 */
public class SearchPanelController {

    SearchPanel view;
    Model m = Model.getInstance();

    public SearchPanelController(SearchPanel searchPanel) {
        view = searchPanel;
    }

    public void search(String searchString) {
        //TODO check if empty string
        view.resultPanel.removeAll(); 
        List<Product> result = m.search(searchString);
        if (result.isEmpty()) {
            view.resultLabel.setText("Inga varor funna från sökningen " + searchString);
        } else {
            if (result.size() > 1) {
                view.resultLabel.setText(result.size() + " matchande varor från sökningen \"" + searchString +"\"");
            } else {
                view.resultLabel.setText(result.size() + " vara funnen från sökningen \"" + searchString + "\"");
            }
            view.resultPanel.add(new ProductsPanel(result));
        }
        view.resultPanel.revalidate();
        view.resultPanel.repaint();
    }
}

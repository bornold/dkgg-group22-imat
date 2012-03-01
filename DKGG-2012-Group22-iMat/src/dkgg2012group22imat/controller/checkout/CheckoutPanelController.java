/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.checkout;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.checkout.CheckoutPanel;
import java.util.Iterator;
import java.util.List;
import se.chalmers.ait.dat215.project.ShoppingCartListener;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author jonas
 */
public class CheckoutPanelController implements ShoppingCartListener {
    CheckoutPanel view;
    Model m = Model.getInstance();
    List<ShoppingItem> si;
    Iterator<ShoppingItem> siIt;
    
    public CheckoutPanelController(CheckoutPanel view){
        this.view = view;
        
        view.setErrorMessages(false);
        
        m.getShoppingCart().addShoppingCartListener(this);
        
        atStart();
        
    }
    public void atStart(){
        if(!m.getCustomer().getFirstName().equals("")){
            view.setFirstName(m.getCustomer().getFirstName());
            view.setLastName(m.getCustomer().getLastName());
            view.setAddress(m.getCustomer().getAddress());
            view.setPostAddress(m.getCustomer().getPostAddress());
            view.setPostcode(m.getCustomer().getPostCode());
            view.setPhoneNumb(m.getCustomer().getPhoneNumber());
            view.setEmail(m.getCustomer().getEmail());
            view.setCardType(m.getCreditCard().getCardType());
            view.setCardName(m.getCreditCard().getHoldersName());
            view.setCardDates(m.getCreditCard().getValidYear(),
                    m.getCreditCard().getValidMonth());
            view.setCardNumber(m.getCreditCard().getCardNumber());
            view.setCVC(m.getCreditCard().getVerificationCode());
            System.out.println("Customer and CreditCard is used from before");
        }
    }
    public void saveInfo(){ 
        m.getCustomer().setFirstName(view.getFirstName());
        m.getCustomer().setLastName(view.getLastName());
        m.getCustomer().setAddress(view.getAddress());
        m.getCustomer().setPostAddress(view.getPostAddress());
        m.getCustomer().setPostCode(view.getPostcode());
        m.getCustomer().setPhoneNumber(view.getPhoneNumb());
        m.getCustomer().setEmail(view.getEmail());
        m.getCreditCard().setCardType(view.getCardType());
        m.getCreditCard().setHoldersName(view.getCardName());
        m.getCreditCard().setValidMonth(view.getCardMonth());
        m.getCreditCard().setValidYear(view.getCardYear());
        m.getCreditCard().setCardNumber(view.getCardNumber());
        m.getCreditCard().setVerificationCode(view.getVerificationCode());
        System.out.println("Customer and CreditCard saved");
    }
    
    public String getCustomer(){
        return "<html>"+"Förnamn: " + m.getCustomer().getFirstName() + "<br>"
                + "Efternamn: " + m.getCustomer().getLastName() + "<br>"
                + "Address: " + m.getCustomer().getAddress() + "<br>"
                + "Postnummer: " + m.getCustomer().getPostCode() + "<br>"
                + "Postaddress: " + m.getCustomer().getPostAddress() + "<br>"
                + "Telefonnummer: " + m.getCustomer().getPhoneNumber() + "<br>"
                + "Email: " + m.getCustomer().getEmail() + "<br>"
                + "Kort typ: " + m.getCreditCard().getCardType() + "<br>"
                + "Kortnamn: " + m.getCreditCard().getHoldersName() + "<br>"
                + "Utgångsdatum(År/Månad): " + m.getCreditCard().getValidYear() 
                        + " / " + m.getCreditCard().getValidMonth() + "<br>"
                + "Kortnummer: " + m.getCreditCard().getCardNumber() + "<br>"
                + "Kortets CVC: " + m.getCreditCard().getVerificationCode()
                + "</html>";
    }
    
    public String getProducts(){
        String siString = "";
        si = m.getShoppingCart().getItems();
        siIt = si.iterator();
        siString = "<html>";
        for(ShoppingItem sit : si){
            siString = siString + sit.getProduct().getName() + "       "
                    + "------- Pris: " + (Math.round(sit.getTotal() * 100.0) /100.0) + " kr <br>";
        }
        siString += "</html>";
        return siString;
    }
    
    public void clearCart(){
        m.getShoppingCart().clear();
    }
    
    public String getTotal(){
        return ""+(Math.round(m.getShoppingCart().getTotal() * 100.0) /100.0) + " kr";
    }
    
    public void performBuy(){
        m.placeOrder();
    }
    
    public int getProductsAmount(){
        return m.getShoppingCart().getItems().size();
    }

    public void shoppingCartChanged() {
        this.view.updateSecondView();
    }
}

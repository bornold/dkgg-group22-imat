/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.controller.checkout;

import dkgg2012group22imat.model.Model;
import dkgg2012group22imat.view.checkout.CheckoutPanel;

/**
 *
 * @author jonas
 */
public class CheckoutPanelController {
    CheckoutPanel view;
    Model m = Model.getInstance();
    
    public CheckoutPanelController(CheckoutPanel view){
        this.view = view;
        
        view.setErrorMessages(false);
        atStart();
        
    }
    public void atStart(){
        System.out.println(m.getCustomer().getFirstName());
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
        System.out.println(m.getCustomer().getFirstName());
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
        System.out.println(m.getCustomer().getFirstName());
    }
}

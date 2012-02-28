/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CheckoutPanel.java
 *
 * Created on Feb 22, 2012, 2:43:43 PM
 */
package dkgg2012group22imat.view.checkout;

import dkgg2012group22imat.controller.checkout.CheckoutPanelController;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jonas
 */
public class CheckoutPanel extends javax.swing.JPanel {

    int credCardKeyTyped;
    ArrayList<JTextField> jField;
    Iterator<JTextField> jFieldIt;
    ArrayList<JLabel> jLabels;
    Iterator<JLabel> jLabelsIt;
    CheckoutPanelController controller;
    boolean focusCardNumbfield1 = false;
    boolean focusCardNumbfield2 = false;
    boolean focusCardNumbfield3 = false;
    boolean focusCardNumbfield4 = false;
    String cardnumber = "";

    /** Creates new form CheckoutPanel */
    public CheckoutPanel() {
        initComponents();
        controller = new CheckoutPanelController(this);
        jField = new ArrayList();
        jLabels = new ArrayList();
        controller.atStart();
    }

    public void setFirstName(String name) {
        lastNameTextfield.setText(name);
    }

    public void setLastName(String lastName) {
        firstNameTextfield.setText(lastName);
    }

    public void setAddress(String address) {
        addressTextfield.setText(address);
    }

    public void setPostAddress(String pAddress) {
        postAddressTextfield.setText(pAddress);
    }

    public void setPostcode(String postNumb) {
        postCodeTextfield.setText(postNumb);
    }

    public void setPhoneNumb(String pNumb) {
        phoneNumbTextfield.setText(pNumb);
    }

    public void setEmail(String email) {
        emailTextfield.setText(email);
    }

    public void setCardType(String card) {
        if (card.equals("Visa")) {
            visaRButton.setSelected(true);
        }

        if (card.equals("Mastercard")) {
            masterRButton.setSelected(true);
        }
    }

    public void setCardName(String name) {
        cardNameTextfield.setText(name);
    }

    public void setCardDates(int y, int m) {
        cardYearTextfield.setText(y + "");
        cardMonthTextfield.setText(m + "");
    }

    public void setCardNumber(String number) {
        if (number.length() > 15) {
            cCardNumbfield1.setText(number.substring(0, 3));
            cCardNumbfield1.setText(number.substring(4, 7));
            cCardNumbfield1.setText(number.substring(8, 11));
            cCardNumbfield1.setText(number.substring(12));
        }
    }

    public void setCVC(int cvc) {
        cvcTextfield.setText(cvc + "");
    }

    public String getFirstName() {
        if (firstNameTextfield.getText().equals("")) {
            jField.add(firstNameTextfield);
            jLabels.add(firstNameErrLabel);
        }
        return firstNameTextfield.getText();
    }

    public String getLastName() {
        if (lastNameTextfield.getText().equals("")) {
            jField.add(lastNameTextfield);
            jLabels.add(lastNameErrLabel);
        }
        return firstNameTextfield.getText();
    }

    public String getAddress() {
        if (addressTextfield.getText().equals("")) {
            jField.add(addressTextfield);
            jLabels.add(addressErrLabel);
        }
        return addressTextfield.getText();
    }

    public String getPostAddress() {
        if (postAddressTextfield.getText().equals("")) {
            jField.add(postAddressTextfield);
            jLabels.add(postAddressErrLabel);
        }
        return postAddressTextfield.getText();
    }

    public String getPostcode() {
        if (postCodeTextfield.getText().equals("")) {
            jField.add(postCodeTextfield);
            jLabels.add(postCodeErrLabel);
        }
        return postCodeTextfield.getText();
    }

    public String getPhoneNumb() {
        if (phoneNumbTextfield.getText().equals("")) {
            jField.add(phoneNumbTextfield);
            jLabels.add(phoneNumbErrLabel);
        }
        return phoneNumbTextfield.getText();
    }

    public String getEmail() {
        if (emailTextfield.getText().equals("")) {
            jField.add(emailTextfield);
            jLabels.add(emailErrLabel);
        }
        return emailTextfield.getText();
    }

    public String getCardType() {
        if (!visaRButton.isSelected() && !masterRButton.isSelected()) {
            jLabels.add(cardTypeErrLabel);
        }
        if (visaRButton.isSelected()) {
            return "visa";
        } else {
            return "mastercard";
        }
    }

    public String getCardName() {
        if (cardNameTextfield.getText().equals("")) {
            jField.add(cardNameTextfield);
            jLabels.add(cardNameErrLabel);
        }

        return cardNameTextfield.getText();
    }

    public int getCardYear() {
        try {
            Integer.parseInt(cardYearTextfield.getText());
        } catch (NumberFormatException e) {
            jField.add(cardYearTextfield);
            jLabels.add(cardDatesErrLabel);
            return 0;
        }
        return Integer.parseInt(cardYearTextfield.getText());
    }

    public int getCardMonth() {
        try {
            Integer.parseInt(cardMonthTextfield.getText());
        } catch (NumberFormatException e) {
            jField.add(cardMonthTextfield);
            jLabels.add(cardDatesErrLabel);
            return 0;
        }
        return Integer.parseInt(cardMonthTextfield.getText());
    }

    public int getVerificationCode() {
        try {
            Integer.parseInt(cvcTextfield.getText());
        } catch (NumberFormatException e) {
            jField.add(cvcTextfield);
            jLabels.add(CVCErrLabel);
            return 0;
        }
        return Integer.parseInt(cvcTextfield.getText());
    }

    public String getCardNumber() {
        if (cCardNumbfield1.getText().equals("") || cCardNumbfield2.getText().equals("")
                || cCardNumbfield3.getText().equals("")
                || cCardNumbfield4.getText().equals("")) {
            jField.add(cCardNumbfield1);
            jField.add(cCardNumbfield2);
            jField.add(cCardNumbfield3);
            jField.add(cCardNumbfield4);
            jLabels.add(cardNumberErrLabel);
        }
        return cCardNumbfield1.getText() + cCardNumbfield2.getText()
                + cCardNumbfield3.getText() + cCardNumbfield4.getText();
    }

    public void setErrorMessages(boolean error) {
        firstNameErrLabel.setVisible(error);
        lastNameErrLabel.setVisible(error);
        addressErrLabel.setVisible(error);
        postAddressErrLabel.setVisible(error);
        postCodeErrLabel.setVisible(error);
        phoneNumbErrLabel.setVisible(error);
        emailErrLabel.setVisible(error);
        cardTypeErrLabel.setVisible(error);
        cardNameErrLabel.setVisible(error);
        cardDatesErrLabel.setVisible(error);
        cardNumberErrLabel.setVisible(error);
        CVCErrLabel.setVisible(error);
    }

    public void setTextFieldBackgrounds() {
        firstNameTextfield.setBackground(new Color(255, 255, 255));
        lastNameTextfield.setBackground(new Color(255, 255, 255));
        addressTextfield.setBackground(new Color(255, 255, 255));
        postAddressTextfield.setBackground(new Color(255, 255, 255));
        postCodeTextfield.setBackground(new Color(255, 255, 255));
        phoneNumbTextfield.setBackground(new Color(255, 255, 255));
        emailTextfield.setBackground(new Color(255, 255, 255));
        cardNameTextfield.setBackground(new Color(255, 255, 255));
        cardMonthTextfield.setBackground(new Color(255, 255, 255));
        cardYearTextfield.setBackground(new Color(255, 255, 255));
        cCardNumbfield1.setBackground(new Color(255, 255, 255));
        cCardNumbfield2.setBackground(new Color(255, 255, 255));
        cCardNumbfield3.setBackground(new Color(255, 255, 255));
        cCardNumbfield4.setBackground(new Color(255, 255, 255));
        cvcTextfield.setBackground(new Color(255, 255, 255));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 200), new java.awt.Dimension(0, 200), new java.awt.Dimension(32767, 200));
        jPanel2 = new javax.swing.JPanel();
        lastNameTextfield = new javax.swing.JTextField();
        addressTextfield = new javax.swing.JTextField();
        postAddressTextfield = new javax.swing.JTextField();
        postCodeTextfield = new javax.swing.JTextField();
        phoneNumbTextfield = new javax.swing.JTextField();
        emailTextfield = new javax.swing.JTextField();
        firstNameTextfield = new javax.swing.JTextField();
        firstNameErrLabel = new javax.swing.JLabel();
        lastNameErrLabel = new javax.swing.JLabel();
        addressErrLabel = new javax.swing.JLabel();
        postAddressErrLabel = new javax.swing.JLabel();
        postCodeErrLabel = new javax.swing.JLabel();
        phoneNumbErrLabel = new javax.swing.JLabel();
        emailErrLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cardTypeLabel = new javax.swing.JLabel();
        cardNameLabel = new javax.swing.JLabel();
        cardDatesLabel = new javax.swing.JLabel();
        cardNumberLabel = new javax.swing.JLabel();
        CVCLabel = new javax.swing.JLabel();
        Betalningsinformation = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cvcTextfield = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        cCardNumbfield1 = new javax.swing.JTextField();
        cCardNumbfield4 = new javax.swing.JTextField();
        cCardNumbfield2 = new javax.swing.JTextField();
        cCardNumbfield3 = new javax.swing.JTextField();
        cardMonthTextfield = new javax.swing.JTextField();
        cardYearTextfield = new javax.swing.JTextField();
        cardNameTextfield = new javax.swing.JTextField();
        visaRButton = new javax.swing.JRadioButton();
        masterRButton = new javax.swing.JRadioButton();
        cardTypeErrLabel = new javax.swing.JLabel();
        cardNameErrLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cardDatesErrLabel = new javax.swing.JLabel();
        cardNumberErrLabel = new javax.swing.JLabel();
        CVCErrLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        förNamnLabel = new javax.swing.JLabel();
        efterNamnLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        postAddressLabel = new javax.swing.JLabel();
        postCodeLabel = new javax.swing.JLabel();
        phoneNumbLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        kontaktinformation = new javax.swing.JLabel();

        setName("Form"); // NOI18N

        filler1.setName("filler1"); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setOpaque(false);

        lastNameTextfield.setName("lastNameTextfield"); // NOI18N
        lastNameTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastNameTextfieldMouseClicked(evt);
            }
        });

        addressTextfield.setName("adressTextfield"); // NOI18N
        addressTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addressTextfieldMouseClicked(evt);
            }
        });

        postAddressTextfield.setName("postadressTextfield"); // NOI18N
        postAddressTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postAddressTextfieldMouseClicked(evt);
            }
        });

        postCodeTextfield.setName("postcodetextfield"); // NOI18N
        postCodeTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postCodeTextfieldMouseClicked(evt);
            }
        });

        phoneNumbTextfield.setName("phonenumberTextfield"); // NOI18N
        phoneNumbTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneNumbTextfieldMouseClicked(evt);
            }
        });

        emailTextfield.setName("emailTextfield"); // NOI18N
        emailTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailTextfieldMouseClicked(evt);
            }
        });

        firstNameTextfield.setName("firstNameTextfield"); // NOI18N
        firstNameTextfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstNameTextfieldMouseClicked(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(CheckoutPanel.class);
        firstNameErrLabel.setForeground(resourceMap.getColor("firstNameErrLabel.foreground")); // NOI18N
        firstNameErrLabel.setText(resourceMap.getString("firstNameErrLabel.text")); // NOI18N
        firstNameErrLabel.setName("firstNameErrLabel"); // NOI18N

        lastNameErrLabel.setForeground(resourceMap.getColor("lastNameErrLabel.foreground")); // NOI18N
        lastNameErrLabel.setText(resourceMap.getString("lastNameErrLabel.text")); // NOI18N
        lastNameErrLabel.setName("lastNameErrLabel"); // NOI18N

        addressErrLabel.setForeground(resourceMap.getColor("addressErrLabel.foreground")); // NOI18N
        addressErrLabel.setText(resourceMap.getString("addressErrLabel.text")); // NOI18N
        addressErrLabel.setName("addressErrLabel"); // NOI18N

        postAddressErrLabel.setForeground(resourceMap.getColor("cardDatesErrLabel.foreground")); // NOI18N
        postAddressErrLabel.setText(resourceMap.getString("postAddressErrLabel.text")); // NOI18N
        postAddressErrLabel.setName("postAddressErrLabel"); // NOI18N

        postCodeErrLabel.setForeground(resourceMap.getColor("cardDatesErrLabel.foreground")); // NOI18N
        postCodeErrLabel.setText(resourceMap.getString("postCodeErrLabel.text")); // NOI18N
        postCodeErrLabel.setName("postCodeErrLabel"); // NOI18N

        phoneNumbErrLabel.setForeground(resourceMap.getColor("cardDatesErrLabel.foreground")); // NOI18N
        phoneNumbErrLabel.setText(resourceMap.getString("phoneNumbErrLabel.text")); // NOI18N
        phoneNumbErrLabel.setName("phoneNumbErrLabel"); // NOI18N

        emailErrLabel.setForeground(resourceMap.getColor("emailErrLabel.foreground")); // NOI18N
        emailErrLabel.setText(resourceMap.getString("emailErrLabel.text")); // NOI18N
        emailErrLabel.setName("emailErrLabel"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(firstNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameErrLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(postAddressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postAddressErrLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(postCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postCodeErrLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phoneNumbTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneNumbErrLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(emailTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailErrLabel))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(addressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addressErrLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lastNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lastNameErrLabel))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameErrLabel))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postAddressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postAddressErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postCodeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(postCodeErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumbTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumbErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailErrLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setOpaque(false);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);

        cardTypeLabel.setText(resourceMap.getString("cardTypeLabel.text")); // NOI18N
        cardTypeLabel.setName("cardTypeLabel"); // NOI18N

        cardNameLabel.setText(resourceMap.getString("cardNameLabel.text")); // NOI18N
        cardNameLabel.setName("cardNameLabel"); // NOI18N

        cardDatesLabel.setText(resourceMap.getString("cardDatesLabel.text")); // NOI18N
        cardDatesLabel.setName("cardDatesLabel"); // NOI18N

        cardNumberLabel.setText(resourceMap.getString("cardNumberLabel.text")); // NOI18N
        cardNumberLabel.setName("cardNumberLabel"); // NOI18N

        CVCLabel.setText(resourceMap.getString("CVCLabel.text")); // NOI18N
        CVCLabel.setName("CVCLabel"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardDatesLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CVCLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cardTypeLabel)
                .addGap(18, 18, 18)
                .addComponent(cardNameLabel)
                .addGap(18, 18, 18)
                .addComponent(cardDatesLabel)
                .addGap(18, 18, 18)
                .addComponent(cardNumberLabel)
                .addGap(18, 18, 18)
                .addComponent(CVCLabel)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        Betalningsinformation.setFont(resourceMap.getFont("Betalningsinformation.font")); // NOI18N
        Betalningsinformation.setText(resourceMap.getString("Betalningsinformation.text")); // NOI18N
        Betalningsinformation.setName("Betalningsinformation"); // NOI18N

        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setOpaque(false);

        cvcTextfield.setBackground(resourceMap.getColor("cvcTextfield.background")); // NOI18N
        cvcTextfield.setName("cvcTextfield"); // NOI18N
        cvcTextfield.setSize(new java.awt.Dimension(18, 40));

        jPanel6.setName("jPanel6"); // NOI18N
        jPanel6.setOpaque(false);

        cCardNumbfield1.setName("cCardNumbfield1"); // NOI18N
        cCardNumbfield1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cCardNumbfield1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cCardNumbfieldTyped(evt);
            }
        });

        cCardNumbfield4.setName("cCardNumbfield4"); // NOI18N

        cCardNumbfield2.setName("cCardNumbfield2"); // NOI18N
        cCardNumbfield2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cCardNumbfield2KeyTyped(evt);
            }
        });

        cCardNumbfield3.setName("cCardNumbfield3"); // NOI18N
        cCardNumbfield3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cCardNumbfield3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(cCardNumbfield1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cCardNumbfield2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cCardNumbfield3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cCardNumbfield4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cCardNumbfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cCardNumbfield2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cCardNumbfield3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cCardNumbfield4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardMonthTextfield.setName("cardMonthTextfield"); // NOI18N

        cardYearTextfield.setName("cardYearTextfield"); // NOI18N

        cardNameTextfield.setName("cardNameTextfield"); // NOI18N

        buttonGroup1.add(visaRButton);
        visaRButton.setText(resourceMap.getString("visaRButton.text")); // NOI18N
        visaRButton.setName("visaRButton"); // NOI18N

        buttonGroup1.add(masterRButton);
        masterRButton.setText(resourceMap.getString("masterRButton.text")); // NOI18N
        masterRButton.setName("masterRButton"); // NOI18N

        cardTypeErrLabel.setForeground(resourceMap.getColor("cardDatesErrLabel.foreground")); // NOI18N
        cardTypeErrLabel.setText(resourceMap.getString("cardTypeErrLabel.text")); // NOI18N
        cardTypeErrLabel.setName("cardTypeErrLabel"); // NOI18N

        cardNameErrLabel.setForeground(resourceMap.getColor("cardDatesErrLabel.foreground")); // NOI18N
        cardNameErrLabel.setText(resourceMap.getString("cardNameErrLabel.text")); // NOI18N
        cardNameErrLabel.setName("cardNameErrLabel"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        cardDatesErrLabel.setForeground(resourceMap.getColor("cardDatesErrLabel.foreground")); // NOI18N
        cardDatesErrLabel.setText(resourceMap.getString("cardDatesErrLabel.text")); // NOI18N
        cardDatesErrLabel.setName("cardDatesErrLabel"); // NOI18N

        cardNumberErrLabel.setForeground(resourceMap.getColor("cardNumberErrLabel.foreground")); // NOI18N
        cardNumberErrLabel.setText(resourceMap.getString("cardNumberErrLabel.text")); // NOI18N
        cardNumberErrLabel.setName("cardNumberErrLabel"); // NOI18N

        CVCErrLabel.setForeground(resourceMap.getColor("cardDatesErrLabel.foreground")); // NOI18N
        CVCErrLabel.setText(resourceMap.getString("CVCErrLabel.text")); // NOI18N
        CVCErrLabel.setName("CVCErrLabel"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cardNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardNameErrLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cvcTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CVCErrLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cardYearTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardMonthTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardDatesErrLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cardNumberErrLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(visaRButton)
                        .addGap(18, 18, 18)
                        .addComponent(masterRButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardTypeErrLabel)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visaRButton)
                    .addComponent(masterRButton)
                    .addComponent(cardTypeErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardNameErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardYearTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cardMonthTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardDatesErrLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cardNumberErrLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cvcTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CVCErrLabel)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Betalningsinformation)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Betalningsinformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        confirmButton.setText(resourceMap.getString("confirmButton.text")); // NOI18N
        confirmButton.setName("confirmButton"); // NOI18N
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);

        förNamnLabel.setText(resourceMap.getString("förNamnLabel.text")); // NOI18N
        förNamnLabel.setName("förNamnLabel"); // NOI18N

        efterNamnLabel.setText(resourceMap.getString("efterNamnLabel.text")); // NOI18N
        efterNamnLabel.setName("efterNamnLabel"); // NOI18N

        addressLabel.setText(resourceMap.getString("addressLabel.text")); // NOI18N
        addressLabel.setName("addressLabel"); // NOI18N

        postAddressLabel.setText(resourceMap.getString("postAddressLabel.text")); // NOI18N
        postAddressLabel.setName("postAddressLabel"); // NOI18N

        postCodeLabel.setText(resourceMap.getString("postCodeLabel.text")); // NOI18N
        postCodeLabel.setName("postCodeLabel"); // NOI18N

        phoneNumbLabel.setText(resourceMap.getString("phoneNumbLabel.text")); // NOI18N
        phoneNumbLabel.setName("phoneNumbLabel"); // NOI18N

        emailLabel.setText(resourceMap.getString("emailLabel.text")); // NOI18N
        emailLabel.setName("emailLabel"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(phoneNumbLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(postCodeLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(postAddressLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(efterNamnLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(förNamnLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(förNamnLabel)
                .addGap(18, 18, 18)
                .addComponent(efterNamnLabel)
                .addGap(29, 29, 29)
                .addComponent(addressLabel)
                .addGap(18, 18, 18)
                .addComponent(postAddressLabel)
                .addGap(18, 18, 18)
                .addComponent(postCodeLabel)
                .addGap(18, 18, 18)
                .addComponent(phoneNumbLabel)
                .addGap(18, 18, 18)
                .addComponent(emailLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kontaktinformation.setFont(resourceMap.getFont("kontaktinformation.font")); // NOI18N
        kontaktinformation.setText(resourceMap.getString("kontaktinformation.text")); // NOI18N
        kontaktinformation.setName("kontaktinformation"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kontaktinformation)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(149, 149, 149)
                            .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(kontaktinformation)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(453, 453, 453))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(confirmButton)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

private void lastNameTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameTextfieldMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_lastNameTextfieldMouseClicked

private void firstNameTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameTextfieldMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_firstNameTextfieldMouseClicked

private void addressTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addressTextfieldMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_addressTextfieldMouseClicked

private void postAddressTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postAddressTextfieldMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_postAddressTextfieldMouseClicked

private void postCodeTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postCodeTextfieldMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_postCodeTextfieldMouseClicked

private void phoneNumbTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneNumbTextfieldMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_phoneNumbTextfieldMouseClicked

private void emailTextfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailTextfieldMouseClicked
// TODO add your handling code here:
}//GEN-LAST:event_emailTextfieldMouseClicked

private void cCardNumbfield1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cCardNumbfield1KeyTyped
    credCardKeyTyped++;
    focusCardNumbfield1 = true;

    if (credCardKeyTyped == 4 && focusCardNumbfield1) {
        cCardNumbfield2.requestFocus();
        credCardKeyTyped = 0;
        focusCardNumbfield1 = false;
    }

}//GEN-LAST:event_cCardNumbfield1KeyTyped

private void cCardNumbfield2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cCardNumbfield2KeyTyped
    credCardKeyTyped++;
    focusCardNumbfield2 = true;

    if (credCardKeyTyped == 4 && focusCardNumbfield2) {
        cCardNumbfield3.requestFocus();
        credCardKeyTyped = 0;
        focusCardNumbfield2 = false;
    }
}//GEN-LAST:event_cCardNumbfield2KeyTyped

private void cCardNumbfield3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cCardNumbfield3KeyTyped
    credCardKeyTyped++;
    focusCardNumbfield3 = true;

    if (credCardKeyTyped == 4 && focusCardNumbfield3) {
        cCardNumbfield3.requestFocus();
        credCardKeyTyped = 0;
        focusCardNumbfield3 = false;
    }
}//GEN-LAST:event_cCardNumbfield3KeyTyped

private void cCardNumbfieldTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cCardNumbfieldTyped
    credCardKeyTyped++;
    focusCardNumbfield1 = true;

    if (credCardKeyTyped == 4 && focusCardNumbfield1) {
        cCardNumbfield2.requestFocus();
        credCardKeyTyped = 0;
        focusCardNumbfield1 = false;
    }
}//GEN-LAST:event_cCardNumbfieldTyped

private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
    controller.saveInfo();
    jFieldIt = jField.iterator();
    setTextFieldBackgrounds();
    while (jFieldIt.hasNext()) {
        jFieldIt.next().setBackground(new Color(255, 153, 153));
    }
    setErrorMessages(false);
    jLabelsIt = jLabels.iterator();
    while (jLabelsIt.hasNext()) {
        jLabelsIt.next().setVisible(true);
    }
    jField.clear();
    jLabels.clear();

}//GEN-LAST:event_confirmButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Betalningsinformation;
    private javax.swing.JLabel CVCErrLabel;
    private javax.swing.JLabel CVCLabel;
    private javax.swing.JLabel addressErrLabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextfield;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cCardNumbfield1;
    private javax.swing.JTextField cCardNumbfield2;
    private javax.swing.JTextField cCardNumbfield3;
    private javax.swing.JTextField cCardNumbfield4;
    private javax.swing.JLabel cardDatesErrLabel;
    private javax.swing.JLabel cardDatesLabel;
    private javax.swing.JTextField cardMonthTextfield;
    private javax.swing.JLabel cardNameErrLabel;
    private javax.swing.JLabel cardNameLabel;
    private javax.swing.JTextField cardNameTextfield;
    private javax.swing.JLabel cardNumberErrLabel;
    private javax.swing.JLabel cardNumberLabel;
    private javax.swing.JLabel cardTypeErrLabel;
    private javax.swing.JLabel cardTypeLabel;
    private javax.swing.JTextField cardYearTextfield;
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField cvcTextfield;
    private javax.swing.JLabel efterNamnLabel;
    private javax.swing.JLabel emailErrLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextfield;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel firstNameErrLabel;
    private javax.swing.JTextField firstNameTextfield;
    private javax.swing.JLabel förNamnLabel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel kontaktinformation;
    private javax.swing.JLabel lastNameErrLabel;
    private javax.swing.JTextField lastNameTextfield;
    private javax.swing.JRadioButton masterRButton;
    private javax.swing.JLabel phoneNumbErrLabel;
    private javax.swing.JLabel phoneNumbLabel;
    private javax.swing.JTextField phoneNumbTextfield;
    private javax.swing.JLabel postAddressErrLabel;
    private javax.swing.JLabel postAddressLabel;
    private javax.swing.JTextField postAddressTextfield;
    private javax.swing.JLabel postCodeErrLabel;
    private javax.swing.JLabel postCodeLabel;
    private javax.swing.JTextField postCodeTextfield;
    private javax.swing.JRadioButton visaRButton;
    // End of variables declaration//GEN-END:variables
}

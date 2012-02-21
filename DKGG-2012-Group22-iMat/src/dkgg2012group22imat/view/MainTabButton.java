/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.ButtonModel;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import org.jdesktop.swingx.graphics.GraphicsUtilities;
import org.jdesktop.swingx.graphics.ShadowRenderer;

/**
 *
 * @author Simon
 */
public class MainTabButton extends JButton {

    private BufferedImage shadow;
    private int shadowSize;
    private Icon icon;
    private Color color;

    public MainTabButton() {
        super();
        this.addMouseListener(new MainTabMouseListener(this));
        //this.setModel(new DefaultButtonModel());
        shadowSize = 5;
        color = new Color(102, 102, 102);
    }

    @Override
    protected void paintComponent(Graphics g) {

        //g.clearRect(0, 0, getWidth(), getHeight());


        //Padding:
        int x = 10;
        int y = 10;

        int w = getWidth() - x * 2;
        //int h = getHeight() - y * 2;
        int h = getHeight() - y * 2 + 20;
        int arc = 25;

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        


        if (shadow != null) {
            int xOffset = (shadow.getWidth() - w) / 2;
            int yOffset = (shadow.getHeight() - h) / 2;
            g2.drawImage(shadow, x - xOffset, y - yOffset, null);
        }
        if (this.getModel().isRollover()) {
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(Color.WHITE);
        }
        g2.fillRoundRect(x, y, w, h, arc, arc);

        if (this.getModel().isRollover()) {
            g2.setColor(new Color(34, 34, 34));
        } else {
            g2.setColor(new Color(102, 102, 102));
        }
        g2.drawRoundRect(x, y, w, h, arc, arc);

        if (this.getModel().isRollover()) {
            g2.setColor(new Color(34, 34, 34));
        } else {
            g2.setColor(new Color(102, 102, 102));
        }

        g2.setFont(new Font("Myriad Pro", Font.PLAIN, 30));

        g2.drawString(this.getText(), 90, 60);
        //g2.drawImage(this.getIcon(), 20, 20, this);

        g2.dispose();
        if (this.getIcon() != null) {
            if (this.getModel().isRollover()) {
                this.getRolloverIcon().paintIcon(this, g, 25, 20);
            } else {
                this.getIcon().paintIcon(this, g, 25, 20);
            }
        }


    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

        int w = getWidth() - 20;
        int h = getHeight();
        int arc = 25;

        shadow = GraphicsUtilities.createCompatibleTranslucentImage(w, h);
        Graphics2D g2 = shadow.createGraphics();
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, -2, w, h, arc, arc);
        g2.dispose();

        ShadowRenderer renderer = new ShadowRenderer(shadowSize, 0.5f, Color.BLACK);
        shadow = renderer.createShadow(shadow);

        //Removes the shadow from the content (in case the background is transparent, which is isnt, ah well who knows what happens in the furure, it makes it good to copy, unless someone writes a stupidly long comment on one line so you need to scroll horizontally to see what stupid things he tries to say, thats very frustrating...
        g2 = shadow.createGraphics();
        g2.setColor(Color.RED);
        g2.setComposite(AlphaComposite.Clear);
        g2.fillRoundRect(shadowSize, shadowSize, w, h, arc, arc);
        g2.dispose();


    }

   /* @Override
    public Dimension getPreferredSize() {
        return new Dimension(210, 80);
    }*/

    private class MainTabMouseListener implements MouseListener {

        private boolean rollover = false;
        private JButton jb;

        public MainTabMouseListener(JButton jb) {
            this.jb = jb;
        }

        public void mouseClicked(MouseEvent me) {
        }

        public void mousePressed(MouseEvent me) {
            jb.getModel().setPressed(true);
        }

        public void mouseReleased(MouseEvent me) {
            jb.getModel().setPressed(false);
        }

        public void mouseEntered(MouseEvent me) {
            jb.getModel().setRollover(true);
        }

        public void mouseExited(MouseEvent me) {
            jb.getModel().setRollover(false);
        }
    }
}

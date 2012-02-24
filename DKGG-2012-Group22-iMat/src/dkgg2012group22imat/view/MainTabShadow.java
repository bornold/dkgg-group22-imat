/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author Simon
 */
public class MainTabShadow extends JLabel {

    Image image;

    public MainTabShadow() {
        super();
        this.setOpaque(false);

        try {
            image = ImageIO.read(getClass().getResourceAsStream("/dkgg2012group22imat/resources/shadow.png"));
        } catch (Exception e) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        this.drawTiled(g);
    }
    /*
     *  Custom painting code for drawing TILED images as the background
     */

    private void drawTiled(Graphics g) {
        Dimension d = getSize();
        int width = image.getWidth(null);
        int height = image.getHeight(null);

        int y = d.height - image.getHeight(null);
        for (int x = 0; x < d.width; x += width) {
            g.drawImage(image, x, y, null, null);
        }
    }
    
    /*
    @Override
    protected void paintComponent(Graphics g) {
    int x = 0;
    int y = getHeight();
    int w = getWidth();
    int h = 10;
    int arc = 0;
    int shadowSize = 40;
    
    BufferedImage shadow = GraphicsUtilities.createCompatibleTranslucentImage(w, h);
    Graphics2D g2 = shadow.createGraphics();
    g2.setColor(Color.WHITE);
    g2.fillRoundRect(0, 0, w, h, arc, arc);
    //g2.dispose();
    
    ShadowRenderer renderer = new ShadowRenderer(shadowSize, 3.0f, Color.BLACK);
    shadow = renderer.createShadow(shadow);
    
    //Removes the shadow from the content (in case the background is transparent, which is isnt, ah well who knows what happens in the furure, it makes it good to copy, unless someone writes a stupidly long comment on one line so you need to scroll horizontally to see what stupid things he tries to say, thats very frustrating...
    g2 = shadow.createGraphics();
    g2.setColor(Color.RED);
    g2.setComposite(AlphaComposite.Clear);
    g2.fillRoundRect(shadowSize, shadowSize, w, h, arc, arc);
    //g2.dispose();
    
    
    g2 = (Graphics2D) g.create();
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
    
    if (shadow != null) {
    int xOffset = (shadow.getWidth() - w) / 2;
    int yOffset = (shadow.getHeight() - h) / 2;
    g2.drawImage(shadow, x - xOffset, y - yOffset, null);
    }
    
    super.paintComponent(g);
    
    
    }*/
}

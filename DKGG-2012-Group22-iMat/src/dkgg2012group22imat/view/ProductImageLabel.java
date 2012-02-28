/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import dkgg2012group22imat.model.IMatUtilities;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Simon
 */
public class ProductImageLabel extends JLabel {

    BufferedImage image;
    ImageFilter resizeFilter;
    ImageProducer imageProducer;
    Dimension dimensions;

    public ProductImageLabel() {
        super();
    }

    public ProductImageLabel(ImageIcon image) {
        this.setImage(image);
        
    }

    public void setImage(ImageIcon image) {
        this.image = IMatUtilities.getBufferedImageFromImage(image.getImage());
    }
    
    public Image getImage() {
        return this.image;
    }
    
    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        
        AffineTransform at = AffineTransform.getScaleInstance(0.5, 0.5);
            AffineTransformOp aop =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
            g2d.drawImage(image, aop, 0, 0);
    }

}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.ReplicateScaleFilter;
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
    }

    public ProductImageLabel(ImageIcon image) {
        this.setImage(image);
    }

    public void setImage(ImageIcon image) {
        this.image = getBufferedImageFromImage(image.getImage());
    }
    
    private BufferedImage getBufferedImageFromImage(Image img) 
    { 
        //This line is important, this makes sure that the image is 
        //loaded fully 
        img = new ImageIcon(img).getImage(); 
         
        //Create the BufferedImage object with the width and height of the Image 
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB); 

        //Create the graphics object from the BufferedImage 
        Graphics g = bufferedImage.createGraphics(); 

        //Draw the image on the graphics of the BufferedImage 
        g.drawImage(img, 0, 0, null); 
         
        //Dispose the Graphics 
        g.dispose(); 
         
        //return the BufferedImage 
        return bufferedImage; 
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
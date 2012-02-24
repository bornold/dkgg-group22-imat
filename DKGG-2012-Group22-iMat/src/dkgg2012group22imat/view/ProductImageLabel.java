/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Simon
 */
public class ProductImageLabel extends JLabel {

    Image image;

    public ProductImageLabel() {
        
    }
    
    
    
    public ProductImageLabel(ImageIcon image) {
        setImage(image);
    }
    
    public void setImage(ImageIcon image) {
        this.image = image.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        Image imagetodraw = this.createImage(new FilteredImageSource(image.getSource(),
                new CropImageFilter(0, 0, 10, 10)));
        
        g.drawImage(imagetodraw, 0, 0, this);
        
    }
}
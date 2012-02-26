/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Simon
 */
public class AnimateImage extends JComponent {

    Rectangle from;
    Rectangle to;
    BufferedImage image;
    int width;
    int height;

    public AnimateImage(Image image, Rectangle from) {
        this.image = IMatUtilities.getBufferedImageFromImage(image);
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.from = from;
        this.setBounds(from.x,from.y,from.width,from.height);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(),image.getHeight());
    }

    @Override
    public void paintComponent(Graphics g) {
        //g.drawImage(image,from.x,from.y,null);
        Graphics2D g2d = (Graphics2D) g.create();


        AffineTransform at = AffineTransform.getScaleInstance((double)this.getWidth()/(double)image.getWidth(), (double)this.getHeight()/(double)image.getHeight());
        AffineTransformOp aop =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);

        g2d.drawImage(this.image, aop, 0, 0);
    }
}

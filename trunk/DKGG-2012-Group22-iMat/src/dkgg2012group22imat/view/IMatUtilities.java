/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.equations.Expo;
import dkgg2012group22imat.controller.iMatViewController;
import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.jdesktop.application.Application;

/**
 *
 * @author Simon
 */
public class IMatUtilities {

    public static void drawTiled(Graphics g, Dimension d, ImageIcon icon) {

        Image image = icon.getImage();

        int width = image.getWidth(null);
        int height = image.getHeight(null);

        for (int x = 0; x < d.width; x += width) {
            for (int y = 0; y < d.height; y += height) {
                g.drawImage(image, x, y, null, null);
            }
        }
    }

    public static void addHoverListener(Component c, MouseListener ml) {
        Toolkit.getDefaultToolkit().addAWTEventListener(new TargetedMouseListener(c, ml), AWTEvent.MOUSE_MOTION_EVENT_MASK);
    }

    public static Dimension getStringDimension(Font font, String text) {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        FontMetrics fontMetrics = g2.getFontMetrics(font);

        return fontMetrics.getStringBounds(text, g2).getBounds().getSize();
    }

    public static BufferedImage getBufferedImageFromImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        } else {
            img = new ImageIcon(img).getImage();
            BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics g = bufferedImage.createGraphics();
            g.drawImage(img, 0, 0, null);
            g.dispose();

            return bufferedImage;
        }
    }

    public static Point getLocationRelativeToFrame(Point p) {
        int locationx = p.x - ((DKGG2012Group22iMatApp) Application.getInstance()).getIMatView().getAnimationPanel().getLocationOnScreen().x;
        int locationy = p.y - ((DKGG2012Group22iMatApp) Application.getInstance()).getIMatView().getAnimationPanel().getLocationOnScreen().y;
        return new Point(locationx, locationy);
    }

    public static void imageFlyAnimation(Image image, Rectangle from, Rectangle to) {

        Tween.enablePooling(false);
        Tween.registerAccessor(JComponent.class, new JComponentTweenAccessor());

        final TweenManager manager = new TweenManager();

        System.out.println("ANIMATE");
        AnimateImage aniImage = new AnimateImage(image, from);

        JPanel aniPanel = ((DKGG2012Group22iMatApp) Application.getInstance()).getIMatView().getAnimationPanel();
        aniPanel.add(aniImage);

        Tween.to(aniImage, JComponentTweenAccessor.POSITION_SCALE_XY, 1000).target(to.x, to.y, to.width, to.height).delay(16).ease(Expo.INOUT).start(manager);

        Thread t = new Thread() {

            @Override
            public void run() {
                boolean isRunning = true;
                int lastMillis = (int) System.currentTimeMillis();
                while (isRunning) {
                    try {
                        sleep(16);
                    } catch (InterruptedException e) {
                    }
                    int deltaMillis = (int) (System.currentTimeMillis() - lastMillis);
                    manager.update(deltaMillis);
                    

                    lastMillis = (int) System.currentTimeMillis();
                }
            }
        };
        /*new DrawingCanvas() {
        
        @Override
        protected void update(int elapsedMillis) {
        manager.update(elapsedMillis);
        }
        }.start();*/

        t.start();

    }
    
    public static iMatViewController getIMatViewController() {
        return DKGG2012Group22iMatApp.getApplication().getIMatView().getController();
    }
}

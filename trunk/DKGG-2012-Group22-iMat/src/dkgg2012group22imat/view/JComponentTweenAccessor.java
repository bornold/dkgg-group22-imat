/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import aurelienribon.tweenengine.TweenAccessor;
import java.awt.Point;
import javax.swing.JComponent;

/**
 *
 * @author Simon
 */
public class JComponentTweenAccessor implements TweenAccessor<JComponent> {

    // The following lines define the different possible tween types.
    // It's up to you to define what you need :-)

    public static final int POSITION_X = 1;
    public static final int POSITION_Y = 2;
    public static final int POSITION_XY = 3;
    public static final int POSITION_SCALE_XY = 4;
    
    // TweenAccessor implementation

    @Override
    public int getValues(JComponent target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case POSITION_X: returnValues[0] = target.getBounds().x; return 1;
            case POSITION_Y: returnValues[0] = target.getBounds().y; return 1;
            case POSITION_XY:
                returnValues[0] = target.getBounds().x;
                returnValues[1] = target.getBounds().y;
                return 2;
            case POSITION_SCALE_XY:
                returnValues[0] = target.getBounds().x;
                returnValues[1] = target.getBounds().y;
                returnValues[2] = target.getBounds().width;
                returnValues[3] = target.getBounds().height;
                return 4;
            default: assert false; return -1;
        }
    }
    
    @Override
    public void setValues(JComponent target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case POSITION_X: target.setBounds(target.getBounds().x,(int)newValues[0],target.getBounds().width, target.getBounds().height); break;
            case POSITION_Y: target.setBounds((int)newValues[0],target.getBounds().y,target.getBounds().width, target.getBounds().height); break;
            case POSITION_XY:
                target.setBounds((int)newValues[0],(int)newValues[1],target.getBounds().width,target.getBounds().height);
                //target.revalidate();
            case POSITION_SCALE_XY:
                target.setBounds((int)newValues[0],(int)newValues[1],(int)newValues[2],(int)newValues[3]);
                //target.revalidate();
                //target.repaint();
                break;
            default: assert false; break;
        }
    }
}

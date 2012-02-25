/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dkgg2012group22imat.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JSpinner.NumberEditor;
import javax.swing.border.LineBorder;
import javax.swing.plaf.SpinnerUI;
import javax.swing.plaf.basic.BasicPanelUI;
import javax.swing.plaf.basic.BasicSpinnerUI;

/**
 *
 * @author Simon
 */
class StyledSpinnerUI extends BasicSpinnerUI {

    private static final Dimension zeroSize = new Dimension(0, 0);

    public static SpinnerUI createUI(JComponent c) {

        return new StyledSpinnerUI();

    }

    @Override
    protected Component createPreviousButton() {
        Component c = createIncDecButton(-1);
        installPreviousButtonListeners(c);
        return c;
    }

    @Override
    protected Component createNextButton() {
        Component c = createIncDecButton(1);
        installNextButtonListeners(c);
        return c;
    }

    private Component createIncDecButton(int direction) {
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(dkgg2012group22imat.view.DKGG2012Group22iMatApp.class).getContext().getResourceMap(StyledSpinnerUI.class);


        String handler;

        if (direction < 0) {
            handler = "decrease";
        } else {
            handler = "increase";
        }
        JButton button = new JButton("");
        button.setIcon(resourceMap.getIcon(handler + ".icon"));
        button.setBorderPainted(false);
        button.setName(handler); // NOI18N
        button.setPressedIcon(resourceMap.getIcon(handler + ".pressedIcon")); // NOI18N
        button.setRolloverIcon(resourceMap.getIcon(handler + ".rolloverIcon")); // NOI18N
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(23,11));


        return button;
    }
    
    @Override 
    protected JComponent createEditor() {
        NumberEditor editor = (NumberEditor)spinner.getEditor();
        editor.setInheritsPopupMenu(true);
        
        //editor.setBorder(new LineBorder(new Color(15,57,141),1,true));
        return editor;
    }
    
    @Override
    protected void installDefaults() {
        spinner.setLayout(createLayout());
        //LookAndFeel.installBorder(spinner, "Spinner.border");
        //LookAndFeel.installColorsAndFont(spinner, "Spinner.background", "Spinner.foreground", "Spinner.font");
        //LookAndFeel.installProperty(spinner, "opaque", Boolean.TRUE);
        spinner.setOpaque(false);
    }

    @Override
    public Dimension getMinimumSize(JComponent jc) {
        return new Dimension(70, 28);
    }

    @Override
    protected LayoutManager createLayout() {
        LayoutManager handlerLayout = new HandlerLayoutManager();
        return handlerLayout;
    }

    private static class HandlerLayoutManager implements LayoutManager {

        private Component nextButton = null;
        private Component previousButton = null;
        private Component editor = null;

        public void addLayoutComponent(String name, Component c) {
            if ("Next".equals(name)) {
                nextButton = c;
            } else if ("Previous".equals(name)) {
                previousButton = c;
            } else if ("Editor".equals(name)) {
                editor = c;
            }
        }

        public void removeLayoutComponent(Component c) {
            if (c == nextButton) {
                c = null;
            } else if (c == previousButton) {
                previousButton = null;
            } else if (c == editor) {
                editor = null;
            }
        }

        private Dimension preferredSize(Component c) {
            return (c == null) ? zeroSize : c.getPreferredSize();
        }

        public Dimension preferredLayoutSize(Container parent) {
            Dimension nextD = preferredSize(nextButton);
            Dimension previousD = preferredSize(previousButton);
            Dimension editorD = preferredSize(editor);

            /* Force the editors height to be a multiple of 2
             */
            editorD.height = ((editorD.height + 1) / 2) * 2;

            Dimension size = new Dimension(editorD.width, editorD.height);
            size.width += Math.max(nextD.width, previousD.width);
            Insets insets = parent.getInsets();
            size.width += insets.left + insets.right;
            size.height += insets.top + insets.bottom;
            return size;
        }

        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        private void setBounds(Component c, int x, int y, int width, int height) {
            if (c != null) {
                c.setBounds(x, y, width, height);
            }
        }

        public void layoutContainer(Container parent) {
            int width = parent.getWidth();
            int height = parent.getHeight();

            Insets insets = new Insets(0,0,0,0);
            Dimension nextD = preferredSize(nextButton);
            Dimension previousD = preferredSize(previousButton);
            int buttonsWidth = Math.max(nextD.width, previousD.width);
            int editorHeight = height - (insets.top + insets.bottom);

            // The arrowButtonInsets value is used instead of the JSpinner's
            // insets if not null. Defining this to be (0, 0, 0, 0) causes the
            // buttons to be aligned with the outer edge of the spinner's
            // border, and leaving it as "null" places the buttons completely
            // inside the spinner's border.
            Insets buttonInsets = insets;
            /* Deal with the spinner's componentOrientation property.
             */
            int editorX, editorWidth, buttonsX;
            
            editorX = 0;
            editorWidth = width-buttonsWidth;
            buttonsX = editorWidth-3;

            int nextY = buttonInsets.top;
            int nextHeight = (height / 2) + (height % 2) - nextY;
            int previousY = buttonInsets.top + nextHeight -2;
            int previousHeight = height - previousY - buttonInsets.bottom;

            setBounds(editor, editorX, insets.top, editorWidth, editorHeight);
            setBounds(nextButton, buttonsX, nextY, buttonsWidth, nextHeight);
            setBounds(previousButton, buttonsX, previousY, buttonsWidth, previousHeight);
        }
    }
}

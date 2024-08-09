package com.airondlph.ui.responsive.component;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;

/**
 *
 * @author Airondlph
 * 
 */
public class ResponsiveFrame extends JFrame {

    public ResponsiveFrame() {
        super();
        theMostImportantThing();
    }
    
    
    private void theMostImportantThing() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
                super.componentResized(e);
            }
        });
    }
    
}

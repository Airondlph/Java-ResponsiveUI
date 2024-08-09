package com.airondlph.ui.responsive;

import java.awt.Component;
import java.awt.Graphics;

/**
 *
 * @author Airondlph
 * 
 */
public interface Responsive {
    // Methods that must be overriden
    public Component add(Component comp);
    public void paint(Graphics g);
    public void repaint();
    
    public void refresh();
}

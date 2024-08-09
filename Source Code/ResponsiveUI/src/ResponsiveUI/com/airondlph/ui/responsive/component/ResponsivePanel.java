package com.airondlph.ui.responsive.component;

import com.airondlph.ui.responsive.ResponsiveLocation;
import com.airondlph.ui.responsive.ResponsiveSize;
import com.airondlph.ui.responsive.data.AbsoluteLocation;
import com.airondlph.ui.responsive.data.AbsoluteSize;
import com.airondlph.ui.responsive.data.RelativeLocation;
import com.airondlph.ui.responsive.data.RelativeSize;
import com.airondlph.ui.responsive.factory.ResponsivePanelFactory;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Objects;
import javax.swing.JPanel;

/**
 *
 * @author Airondlph
 * 
 * Panel that changes its size based in 3 metrics:
 *  - relativeSize: relative metric (percent relative to its parent). Size of the panel if it is not more that maximum or less than minimum.
 *  - minimumSize: absolute metric (pixels). If relative size is less than this value, this value will be the size of the panel.
 *  - maximumSize: absolute metric (pixels). If relative size is more than this value, this value will be the size of the panel.
 * 
 * and change its location based in 3 other metrics:
 *  - relativeLocation
 *  - minimumLocation
 *  - maximumSize
 * 
 */
public class ResponsivePanel extends JPanel implements ResponsiveSize, ResponsiveLocation {
    // Size
    private RelativeSize relativeSize;
    private AbsoluteSize minimumSize;
    private AbsoluteSize maximumSize;
    // Location
    private RelativeLocation relativeLocation;
    private AbsoluteLocation minimumLocation;
    private AbsoluteLocation maximumLocation;
    
    public ResponsivePanel() {
        this( null, null, null, null, null, null );
    }
    
    public ResponsivePanel(RelativeSize relativeSize, AbsoluteSize minimumSize, AbsoluteSize maximumSize) {
        this( relativeSize, minimumSize, maximumSize, null, null, null );
    }
    
    public ResponsivePanel(RelativeLocation relativeLocation, AbsoluteLocation minimumLocation, AbsoluteLocation maximumLocation) {
        this( null, null, null, relativeLocation, minimumLocation, maximumLocation);
    }
    
    public ResponsivePanel(RelativeSize relativeSize, AbsoluteSize minimumSize, AbsoluteSize maximumSize, RelativeLocation relativeLocation, AbsoluteLocation minimumLocation, AbsoluteLocation maximumLocation) {
        super();
        this.relativeSize = new RelativeSize();
        this.minimumSize = new AbsoluteSize();
        this.maximumSize = new AbsoluteSize();
        
        this.relativeLocation = new RelativeLocation();
        this.minimumLocation = new AbsoluteLocation();
        this.maximumLocation = new AbsoluteLocation();
        
        this.setRelativeSize(relativeSize);
        this.setMinSize(minimumSize);
        this.setMaxSize(maximumSize);
    }
    
    public ResponsivePanel(ResponsivePanel responsivePanel) {
        copy(responsivePanel);
    }
    
    @Override
    public RelativeSize getRelativeSize() {
        return this.relativeSize.clone();
    }
    
    @Override
    public void setRelativeSize(RelativeSize relativeSize) {
        if(relativeSize == null) {
            this.relativeSize.setRelativeWidth(null);
            this.relativeSize.setRelativeHeight(null);
            return;
        }
        
        this.relativeSize.setRelativeWidth(relativeSize.getRelativeWidth());
        this.relativeSize.setRelativeHeight(relativeSize.getRelativeHeight());
    }
    
    @Override
    public Double getRelativeWidth() {
        return (relativeSize == null) ? null : this.relativeSize.getRelativeWidth();
    }
    
    @Override
    public void setRelativeWidth(Double relativeWidth) {
        this.relativeSize.setRelativeWidth(relativeWidth);
    }
    
    @Override
    public Double getRelativeHeight() {
        return (relativeSize == null) ? null : this.relativeSize.getRelativeHeight();
    }
    
    @Override
    public void setRelativeHeight(Double relativeHeight) {
        this.relativeSize.setRelativeHeight(relativeHeight);
    }
    
    @Override
    public AbsoluteSize getMinSize() {
        return this.minimumSize.clone();
    }
    
    @Override
    public void setMinSize(AbsoluteSize minimumSize) {
        if(minimumSize == null) {
            this.minimumSize.setAbsoluteWidth(null);
            this.minimumSize.setAbsoluteHeight(null);
            return;
        }
        
        this.minimumSize.setAbsoluteWidth(minimumSize.getAbsoluteWidth());
        this.minimumSize.setAbsoluteHeight(minimumSize.getAbsoluteHeight());
    }
    
    @Override
    public Integer getMinWidth() {
        return (this.minimumSize == null) ? null : this.minimumSize.getAbsoluteWidth();
    }
    
    @Override
    public void setMinWidth(Integer minimumWidth) {
        this.minimumSize.setAbsoluteWidth(minimumWidth);
    }
    
    @Override
    public Integer getMinHeight() {
        return (this.minimumSize == null) ? null : this.minimumSize.getAbsoluteHeight();
    }
    
    @Override
    public void setMinHeight(Integer minimumHeight) {
        this.minimumSize.setAbsoluteHeight(minimumHeight);
    }
    
    @Override
    public AbsoluteSize getMaxSize() {
        return this.maximumSize.clone();
    }
    
    @Override
    public void setMaxSize(AbsoluteSize maximumSize) {
        if(maximumSize == null) {
            this.maximumSize.setAbsoluteWidth(null);
            this.maximumSize.setAbsoluteHeight(null);
            return;
        }
        
        this.maximumSize.setAbsoluteWidth(maximumSize.getAbsoluteWidth());
        this.maximumSize.setAbsoluteHeight(maximumSize.getAbsoluteHeight());
    }
    
    @Override
    public Integer getMaxWidth() {
        return (this.maximumSize == null) ? null : this.maximumSize.getAbsoluteWidth();
    }
    
    @Override
    public void setMaxWidth(Integer maximumWidth) {
        this.maximumSize.setAbsoluteWidth(maximumWidth);
    }
    
    @Override
    public Integer getMaxHeight() {
        return (this.maximumSize == null) ? null : this.maximumSize.getAbsoluteHeight();
    }
    
    @Override
    public void setMaxHeight(Integer maximumHeight) {
        this.maximumSize.setAbsoluteHeight(maximumHeight);
    }
    
    @Override
    public void refreshSize() {
        Dimension size;
        
        if((getParent() == null) || ((size = getParent().getSize()) == null)) {
            // No parent? absolute size
            size = super.getSize();

        } else {
            // Relative size
            if(relativeSize != null) {
                Double width;
                Double height;
                
                if((width = relativeSize.getRelativeWidth()) != null) {
                    if(Objects.equals(relativeSize.getRelativeWidth(), RelativeSize.AUTO)) {
                        size.width = getAvailableWidth();
                    } else {
                        size.width = (int)Math.nextUp((size.width*width)/100);
                    }
                }
                
                if((height = relativeSize.getRelativeHeight()) != null) {
                    if(Objects.equals(relativeSize.getRelativeHeight(), RelativeSize.AUTO)) {
                        size.height = getAvailableHeight();
                    } else {
                        size.height = (int)Math.nextUp((size.height*height)/100);
                    }
                }
            }
        }

        // Check that size > minSize
        if((getMaxWidth() != null) && (size.width > getMaxWidth())) {
            size.width = getMaxWidth();
        }
        
        if((getMaxHeight() != null) && (size.height > getMaxHeight())) {
            size.height = getMaxHeight();
        }
        
        // Check that size < maxSize
        if((getMinWidth() != null) && (size.width < getMinWidth())) {
            size.width = getMinWidth();
        }
        
        if((getMinHeight() != null) && (size.height < getMinHeight())) {
            size.height = getMinHeight();
        }
        
        // Refresh the size
        super.setSize(size);
        super.setPreferredSize(size);
        super.setMinimumSize(size);
        super.setMaximumSize(size);
    }
    
    private int getAvailableWidth() {
        Dimension size = super.getParent().getSize();
        int available = (size == null) ? 0 : size.width;
        int autoCount = 1;
        
        for(Component c : super.getParent().getComponents()) {
            if((c == null) || (Objects.equals(c, this))) {
                continue;
            }
            
            // Checks if it can be AUTO
            if(c instanceof ResponsiveSize responsiveSize) {
                if(Objects.equals(responsiveSize.getRelativeSize().getRelativeWidth(), RelativeSize.AUTO)) {
                    ++autoCount;
                    continue;
                }
            }
            
            if(c != this) {
                available -= c.getSize().width;
            }
            
            if(available < 0) {
                return 0;
            }
        }
        
        return (available <= 0) ? 0 : (int)(available/autoCount);
    }
    
    private int getAvailableHeight() {
        Dimension size = super.getParent().getSize();
        int available = (size == null) ? 0 : size.height;
        int autoCount = 1;
        
        for(Component c : super.getParent().getComponents()) {
            if((c == null) || (Objects.equals(c, this))) {
                continue;
            }
            
            // Checks if it can be AUTO
            if(c instanceof ResponsiveSize responsiveSize) {
                if(Objects.equals(responsiveSize.getRelativeSize().getRelativeHeight(), RelativeSize.AUTO)) {
                    ++autoCount;
                    continue;
                }
            }
            
            if(c != this) {
                available -= c.getSize().height;
            }
            
            if(available < 0) {
                return 0;
            }
        }
        
        return (available <= 0) ? 0 : (int)(available/autoCount);
    }
    
    @Override
    public RelativeLocation getRelativeLocation() {
        return this.relativeLocation.clone();
    }
    
    @Override
    public void setRelativeLocation(RelativeLocation relativeLocation) {
        if(relativeLocation == null) {
            this.relativeLocation.setRelativeX(null);
            this.relativeLocation.setRelativeY(null);
            return;
        }
        
        this.relativeLocation.setRelativeX(relativeLocation.getRelativeX());
        this.relativeLocation.setRelativeY(relativeLocation.getRelativeY());
    }
    
    @Override
    public Double getRelativeX() {
        return (relativeLocation == null) ? null : this.relativeLocation.getRelativeX();
    }
    
    @Override
    public void setRelativeX(Double relativeX) {
        this.relativeLocation.setRelativeX(relativeX);
    }
    
    @Override
    public Double getRelativeY() {
        return (relativeLocation == null) ? null : this.relativeLocation.getRelativeY();
    }
    
    @Override
    public void setRelativeY(Double relativeY) {
        this.relativeLocation.setRelativeY(relativeY);
    }
    
    @Override
    public AbsoluteLocation getMinLocation() {
        return this.minimumLocation.clone();
    }
    
    @Override
    public void setMinLocation(AbsoluteLocation minimumLocation) {
        if(minimumLocation == null) {
            this.minimumLocation.setAbsoluteX(null);
            this.minimumLocation.setAbsoluteY(null);
            return;
        }
        
        this.minimumLocation.setAbsoluteX(minimumLocation.getAbsoluteX());
        this.minimumLocation.setAbsoluteY(minimumLocation.getAbsoluteY());
    }
    
    @Override
    public Integer getMinX() {
        return (this.minimumLocation == null) ? null : this.minimumLocation.getAbsoluteX();
    }
    
    @Override
    public void setMinX(Integer minimumX) {
        this.minimumLocation.setAbsoluteX(minimumX);
    }
    
    @Override
    public Integer getMinY() {
        return (this.minimumLocation == null) ? null : this.minimumLocation.getAbsoluteY();
    }
    
    @Override
    public void setMinY(Integer minimumY) {
        this.minimumLocation.setAbsoluteY(minimumY);
    }
    
    @Override
    public AbsoluteLocation getMaxLocation() {
        return this.maximumLocation.clone();
    }
    
    @Override
    public void setMaxLocation(AbsoluteLocation maximumLocation) {
        if(maximumLocation == null) {
            this.maximumLocation.setAbsoluteX(null);
            this.maximumLocation.setAbsoluteY(null);
            return;
        }
        
        this.maximumLocation.setAbsoluteX(maximumLocation.getAbsoluteX());
        this.maximumLocation.setAbsoluteY(maximumLocation.getAbsoluteY());
    }
    
    @Override
    public Integer getMaxX() {
        return (this.maximumLocation == null) ? null : this.maximumLocation.getAbsoluteX();
    }
    
    @Override
    public void setMaxX(Integer maximumX) {
        this.maximumLocation.setAbsoluteX(maximumX);
    }
    
    @Override
    public Integer getMaxY() {
        return (this.maximumLocation == null) ? null : this.maximumLocation.getAbsoluteY();
    }
    
    @Override
    public void setMaxY(Integer maximumY) {
        this.maximumLocation.setAbsoluteY(maximumY);
    }
    
    @Override
    public void refreshLocation() {
        Dimension size;
        Point location = super.getLocation();
        
        
        if((getParent() == null) || ((size = getParent().getSize()) == null)) {
            return;
        
        } else {
            // Relative location
            if(relativeLocation != null) {  
                Double x;
                Double y;
                
                if((x = relativeLocation.getRelativeX()) != null) {
                    location.x = (int)Math.nextUp((size.width*x)/100);
                }
                
                if((y = relativeLocation.getRelativeY()) != null) {
                    location.y = (int)Math.nextUp((size.height*y)/100);
                }
            }
        }

        // Check that location > minLocation
        if((getMaxX() != null) && (location.x > getMaxX())) {
            location.x = getMaxX();
        }
        
        if((getMaxY() != null) && (location.y > getMaxY())) {
            location.y = getMaxY();
        }
        
        // Check that size < maxSize
        if((getMinX() != null) && (location.x < getMinX())) {
            location.x = getMinX();
        }
        
        if((getMinY() != null) && (location.y < getMinY())) {
            location.y = getMinY();
        }
        
        // Refresh the location
        super.setLocation(location);
    }
    
    @Override
    public Dimension getSize() {
        refresh();
        return super.getSize();
    }
    
    @Override
    public Dimension getPreferredSize() {
        return getSize();
    }
    
    @Override
    public void paint(Graphics g) {
        refresh();
        super.paint(g);
    }

    @Override
    public void repaint() {
        refresh();
        super.repaint();
    }

    @Override
    public Component add(Component comp) {
        Component c = super.add(comp);
        refresh();
        return c;
    }

    @Override
    public void refresh() {
        refreshSize();
        refreshLocation();
    }
    
    // Builder/Factory
    @Override
    public ResponsivePanelFactory getFactory() {
        return new ResponsivePanelFactory(this);
    }
    
    // Copy and Clone
    public final void copy(ResponsivePanel responsivePanel) {
        setRelativeSize(responsivePanel.getRelativeSize());
        setMinSize(responsivePanel.getMinSize());
        setMaxSize(responsivePanel.getMaxSize());
        
        setRelativeLocation(responsivePanel.getRelativeLocation());
        setMinLocation(responsivePanel.getMinLocation());
        setMaxLocation(responsivePanel.getMaxLocation());
    }
    
    public final ResponsivePanel clone() {
        return new ResponsivePanel(this);
    }
}
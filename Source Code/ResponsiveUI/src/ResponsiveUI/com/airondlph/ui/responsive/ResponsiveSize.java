package com.airondlph.ui.responsive;

import com.airondlph.ui.responsive.data.RelativeSize;
import com.airondlph.ui.responsive.data.AbsoluteSize;
import com.airondlph.ui.responsive.factory.ResponsiveSizeFactory;
import java.awt.Dimension;

/**
 *
 * @author Airondlph
 * 
 */
public interface ResponsiveSize extends Responsive {    
    // Methods that must be overriden
    public Dimension getSize();
    public Dimension getPreferredSize();
    
    // Utils
    public void refreshSize();
    
    // Relative size
    public RelativeSize getRelativeSize();
    public void setRelativeSize(RelativeSize relativeSize);
    
    public Double getRelativeWidth();
    public void setRelativeWidth(Double relativeWidth);
    
    public Double getRelativeHeight();
    public void setRelativeHeight(Double relativeHeight);
    
    // Minimum absolute size
    public AbsoluteSize getMinSize();
    public void setMinSize(AbsoluteSize minimumSize);
    
    public Integer getMinWidth();
    public void setMinWidth(Integer minimumWidth);
    
    public Integer getMinHeight();
    public void setMinHeight(Integer minimumHeight);
    
    // Maximum absolute size
    public AbsoluteSize getMaxSize();
    public void setMaxSize(AbsoluteSize minimumSize);
    
    public Integer getMaxWidth();
    public void setMaxWidth(Integer maximumHeight);
    
    public Integer getMaxHeight();
    public void setMaxHeight(Integer maximumHeight);
    
    // Factory
    public ResponsiveSizeFactory getFactory();
}

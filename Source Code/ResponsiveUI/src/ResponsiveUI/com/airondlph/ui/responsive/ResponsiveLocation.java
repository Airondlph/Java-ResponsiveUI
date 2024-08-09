package com.airondlph.ui.responsive;

import com.airondlph.ui.responsive.data.RelativeLocation;
import com.airondlph.ui.responsive.data.AbsoluteLocation;
import com.airondlph.ui.responsive.factory.ResponsiveLocationFactory;
import java.awt.Point;

/**
 *
 * @author Airondlph
 * 
 */
public interface ResponsiveLocation extends Responsive {
    // Methods that must be overriden
    public Point getLocation();
    
    // Utils
    public void refreshLocation();
    
    // Relative size
    public RelativeLocation getRelativeLocation();
    public void setRelativeLocation(RelativeLocation relativeLocation);
    
    public Double getRelativeX();
    public void setRelativeX(Double relativeX);
    
    public Double getRelativeY();
    public void setRelativeY(Double relativeY);
    
    // Minimum absolute size
    public AbsoluteLocation getMinLocation();
    public void setMinLocation(AbsoluteLocation minimumLocation);
    
    public Integer getMinX();
    public void setMinX(Integer minimumX);
    
    public Integer getMinY();
    public void setMinY(Integer minimumY);
    
    // Maximum absolute size
    public AbsoluteLocation getMaxLocation();
    public void setMaxLocation(AbsoluteLocation minimumLocation);
    
    public Integer getMaxX();
    public void setMaxX(Integer maximumY);
    
    public Integer getMaxY();
    public void setMaxY(Integer maximumY);
    
    // Factory
    public ResponsiveLocationFactory getFactory();
}

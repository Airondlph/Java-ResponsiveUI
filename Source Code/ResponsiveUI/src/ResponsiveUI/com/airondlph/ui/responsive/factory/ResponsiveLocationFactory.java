package com.airondlph.ui.responsive.factory;

import com.airondlph.ui.responsive.ResponsiveLocation;
import com.airondlph.ui.responsive.data.AbsoluteLocation;
import com.airondlph.ui.responsive.data.RelativeLocation;

/**
 *
 * @author Airondlph
 * 
 */
public interface ResponsiveLocationFactory {
    // Build
    public ResponsiveLocation build();
    
    // Relative size
    public ResponsiveLocationFactory setRelativeLocation(RelativeLocation relativeLocation);
    public ResponsiveLocationFactory setRelativeX(Double relativeX);
    public ResponsiveLocationFactory setRelativeY(Double relativeY);
    
    // Minimum absolute size
    public ResponsiveLocationFactory setMinLocation(AbsoluteLocation minimumLocation);
    public ResponsiveLocationFactory setMinX(Integer minimumX);
    public ResponsiveLocationFactory setMinY(Integer minimumY);
    
    // Maximum absolute size
    public ResponsiveLocationFactory setMaxLocation(AbsoluteLocation maximumLocation);
    public ResponsiveLocationFactory setMaxX(Integer maximumX);
    public ResponsiveLocationFactory setMaxY(Integer maximumY);
    
} // Factory
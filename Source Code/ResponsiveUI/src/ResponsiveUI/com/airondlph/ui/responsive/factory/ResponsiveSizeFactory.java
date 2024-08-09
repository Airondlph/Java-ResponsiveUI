package com.airondlph.ui.responsive.factory;

import com.airondlph.ui.responsive.ResponsiveSize;
import com.airondlph.ui.responsive.data.AbsoluteSize;
import com.airondlph.ui.responsive.data.RelativeSize;

/**
 *
 * @author Airondlph
 * 
 */
public interface ResponsiveSizeFactory {
    // Build
    public ResponsiveSize build();
    
    // Relative size
    public ResponsiveSizeFactory setRelativeSize(RelativeSize relativeSize);
    public ResponsiveSizeFactory setRelativeWidth(Double relativeWidth);
    public ResponsiveSizeFactory setRelativeHeight(Double relativeHeight);
    
    // Minimum absolute size
    public ResponsiveSizeFactory setMinSize(AbsoluteSize minimumSize);
    public ResponsiveSizeFactory setMinWidth(Integer minimumWidth);
    public ResponsiveSizeFactory setMinHeight(Integer minimumHeight);
    
    // Maximum absolute size
    public ResponsiveSizeFactory setMaxSize(AbsoluteSize maximumSize);
    public ResponsiveSizeFactory setMaxWidth(Integer maximumWidth);
    public ResponsiveSizeFactory setMaxHeight(Integer maximumHeight);
    
} // Factory

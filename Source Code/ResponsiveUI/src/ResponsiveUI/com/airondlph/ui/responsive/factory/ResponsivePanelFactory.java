package com.airondlph.ui.responsive.factory;

import com.airondlph.ui.responsive.component.ResponsivePanel;
import com.airondlph.ui.responsive.data.AbsoluteLocation;
import com.airondlph.ui.responsive.data.AbsoluteSize;
import com.airondlph.ui.responsive.data.RelativeLocation;
import com.airondlph.ui.responsive.data.RelativeSize;

/**
 *
 * @author Airondlph
 * 
 */
public class ResponsivePanelFactory implements ResponsiveSizeFactory, ResponsiveLocationFactory {
    private final ResponsivePanel product;
    
    public ResponsivePanelFactory() {
        this( new ResponsivePanel() );
    }
    
    public ResponsivePanelFactory(ResponsivePanel responsivePanel) {
        this.product = responsivePanel;
    }

    @Override
    public ResponsivePanel build() {
        return product;
    }

    @Override
    public ResponsivePanelFactory setRelativeSize(RelativeSize relativeSize) {
        product.setRelativeSize(relativeSize);
        return this;
    }

    @Override
    public ResponsivePanelFactory setRelativeWidth(Double relativeWidth) {
        product.setRelativeWidth(relativeWidth);
        return this;
    }

    @Override
    public ResponsivePanelFactory setRelativeHeight(Double relativeHeight) {
        product.setRelativeHeight(relativeHeight);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMinSize(AbsoluteSize minimumSize) {
        product.setMinSize(minimumSize);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMinWidth(Integer minimumWidth) {
        product.setMinWidth(minimumWidth);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMinHeight(Integer minimumHeight) {
        product.setMinHeight(minimumHeight);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMaxSize(AbsoluteSize maximumSize) {
        product.setMaxSize(maximumSize);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMaxWidth(Integer maximumWidth) {
        product.setMaxWidth(maximumWidth);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMaxHeight(Integer maximumHeight) {
        product.setMaxHeight(maximumHeight);
        return this;
    }

    @Override
    public ResponsivePanelFactory setRelativeLocation(RelativeLocation relativeLocation) {
        product.setRelativeLocation(relativeLocation);
        return this;
    }

    @Override
    public ResponsivePanelFactory setRelativeX(Double relativeX) {
        product.setRelativeX(relativeX);
        return this;
    }

    @Override
    public ResponsivePanelFactory setRelativeY(Double relativeY) {
        product.setRelativeY(relativeY);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMinLocation(AbsoluteLocation minimumLocation) {
        product.setMinLocation(minimumLocation);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMinX(Integer minimumX) {
        product.setMinX(minimumX);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMinY(Integer minimumY) {
        product.setMinY(minimumY);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMaxLocation(AbsoluteLocation maximumLocation) {
        product.setMaxLocation(maximumLocation);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMaxX(Integer maximumX) {
        product.setMaxX(maximumX);
        return this;
    }

    @Override
    public ResponsivePanelFactory setMaxY(Integer maximumY) {
        product.setMaxY(maximumY);
        return this;
    }

} // Factory

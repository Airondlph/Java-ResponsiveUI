package com.airondlph.ui.responsive.factory;

import com.airondlph.ui.responsive.component.ResponsiveButton;
import com.airondlph.ui.responsive.data.AbsoluteLocation;
import com.airondlph.ui.responsive.data.AbsoluteSize;
import com.airondlph.ui.responsive.data.RelativeLocation;
import com.airondlph.ui.responsive.data.RelativeSize;

/**
 *
 * @author Airondlph
 * 
 */
public class ResponsiveButtonFactory implements ResponsiveSizeFactory, ResponsiveLocationFactory {
    private final ResponsiveButton product;
    
    public ResponsiveButtonFactory() {
        this( new ResponsiveButton() );
    }
    
    public ResponsiveButtonFactory(ResponsiveButton responsiveTextButton) {
        this.product = responsiveTextButton;
    }

    @Override
    public ResponsiveButton build() {
        return product;
    }

    @Override
    public ResponsiveButtonFactory setRelativeSize(RelativeSize relativeSize) {
        product.setRelativeSize(relativeSize);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setRelativeWidth(Double relativeWidth) {
        product.setRelativeWidth(relativeWidth);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setRelativeHeight(Double relativeHeight) {
        product.setRelativeHeight(relativeHeight);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMinSize(AbsoluteSize minimumSize) {
        product.setMinSize(minimumSize);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMinWidth(Integer minimumWidth) {
        product.setMinWidth(minimumWidth);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMinHeight(Integer minimumHeight) {
        product.setMinHeight(minimumHeight);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMaxSize(AbsoluteSize maximumSize) {
        product.setMaxSize(maximumSize);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMaxWidth(Integer maximumWidth) {
        product.setMaxWidth(maximumWidth);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMaxHeight(Integer maximumHeight) {
        product.setMaxHeight(maximumHeight);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setRelativeLocation(RelativeLocation relativeLocation) {
        product.setRelativeLocation(relativeLocation);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setRelativeX(Double relativeX) {
        product.setRelativeX(relativeX);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setRelativeY(Double relativeY) {
        product.setRelativeY(relativeY);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMinLocation(AbsoluteLocation minimumLocation) {
        product.setMinLocation(minimumLocation);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMinX(Integer minimumX) {
        product.setMinX(minimumX);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMinY(Integer minimumY) {
        product.setMinY(minimumY);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMaxLocation(AbsoluteLocation maximumLocation) {
        product.setMaxLocation(maximumLocation);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMaxX(Integer maximumX) {
        product.setMaxX(maximumX);
        return this;
    }

    @Override
    public ResponsiveButtonFactory setMaxY(Integer maximumY) {
        product.setMaxY(maximumY);
        return this;
    }

} // Factory

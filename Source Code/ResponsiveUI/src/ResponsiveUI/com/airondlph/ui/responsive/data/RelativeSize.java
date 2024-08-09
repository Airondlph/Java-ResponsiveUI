package com.airondlph.ui.responsive.data;

/**
 *
 * @author Airondlph
 * 
 */
public class RelativeSize {
    public static final Double AUTO = -1D;
    
    private Double relativeWidth;
    private Double relativeHeight;

    public RelativeSize() {

    }
    
    public RelativeSize(Double relativeWidth, Double relativeHeight) {
        this.relativeWidth = relativeWidth;
        this.relativeHeight = relativeHeight;
    }
    
    public RelativeSize(RelativeSize relativeSize) {
        copy(relativeSize);
    }
    
    public Double getRelativeWidth() {
        return relativeWidth;
    }
    
    public void setRelativeWidth(Double relativeWidth) {
        this.relativeWidth = relativeWidth;
    }
    
    public Double getRelativeHeight() {
        return relativeHeight;
    }
    
    public void setRelativeHeight(Double relativeHeight) {
        this.relativeHeight = relativeHeight;
    }
    
    public final void copy(RelativeSize relativeSize) {
        setRelativeWidth(relativeSize.getRelativeWidth());
        setRelativeHeight(relativeSize.getRelativeHeight());
    }
    
    public final RelativeSize clone() {
        return new RelativeSize(this);
    }
}

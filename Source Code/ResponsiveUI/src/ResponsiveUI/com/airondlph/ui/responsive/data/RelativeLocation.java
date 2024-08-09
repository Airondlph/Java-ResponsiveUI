package com.airondlph.ui.responsive.data;

/**
 *
 * @author Airondlph
 * 
 */
public class RelativeLocation {    
    private Double relativeX;
    private Double relativeY;

    public RelativeLocation() {

    }
    
    public RelativeLocation(Double relativeX, Double relativeY) {
        this.relativeX = relativeX;
        this.relativeY = relativeY;
    }
    
    public RelativeLocation(RelativeLocation relativeLocation) {
        copy(relativeLocation);
    }
    
    public Double getRelativeX() {
        return relativeX;
    }
    
    public void setRelativeX(Double relativeX) {
        this.relativeX = relativeX;
    }
    
    public Double getRelativeY() {
        return relativeY;
    }
    
    public void setRelativeY(Double relativeY) {
        this.relativeY = relativeY;
    }
    
    public final void copy(RelativeLocation relativeLocation) {
        setRelativeX(relativeLocation.getRelativeX());
        setRelativeY(relativeLocation.getRelativeY());
    }
    
    public final RelativeLocation clone() {
        return new RelativeLocation(this);
    }
}

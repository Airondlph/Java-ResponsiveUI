package com.airondlph.ui.responsive.data;

/**
 *
 * @author Airondlph
 * 
 */
public class AbsoluteLocation {
    private Integer absoluteX;
    private Integer absoluteY;

    public AbsoluteLocation() {
        
    }
    
    public AbsoluteLocation(Integer absoluteX, Integer absoluteY) {
        this.absoluteX = absoluteX;
        this.absoluteY = absoluteY;
    }
    
    public AbsoluteLocation(AbsoluteLocation absoluteLocation) {
        copy(absoluteLocation);
    }
    
    public Integer getAbsoluteX() {
        return absoluteX;
    }
    
    public void setAbsoluteX(Integer absoluteX) {
        this.absoluteX = absoluteX;
    }
    
    public Integer getAbsoluteY() {
        return absoluteY;
    }
    
    public void setAbsoluteY(Integer absoluteY) {
        this.absoluteY = absoluteY;
    }
    
    public final void copy(AbsoluteLocation absoluteLocation) {
        setAbsoluteX(absoluteLocation.getAbsoluteX());
        setAbsoluteY(absoluteLocation.getAbsoluteY());
    }
    
    public final AbsoluteLocation clone() {
        return new AbsoluteLocation(this);
    }
}

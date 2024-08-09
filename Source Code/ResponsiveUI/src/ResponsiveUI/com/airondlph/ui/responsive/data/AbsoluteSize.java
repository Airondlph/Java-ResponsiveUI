package com.airondlph.ui.responsive.data;

/**
 *
 * @author Airondlph
 * 
 */
public class AbsoluteSize {
    private Integer absoluteWidth;
    private Integer absoluteHeight;

    public AbsoluteSize() {
        
    }
    
    public AbsoluteSize(Integer absoluteWidth, Integer absoluteHeight) {
        this.absoluteWidth = absoluteWidth;
        this.absoluteHeight = absoluteHeight;
    }
    
    public AbsoluteSize(AbsoluteSize absoluteSize) {
        copy(absoluteSize);
    }
    
    public Integer getAbsoluteWidth() {
        return absoluteWidth;
    }
    
    public void setAbsoluteWidth(Integer absoluteWidth) {
        this.absoluteWidth = absoluteWidth;
    }
    
    public Integer getAbsoluteHeight() {
        return absoluteHeight;
    }
    
    public void setAbsoluteHeight(Integer absoluteHeight) {
        this.absoluteHeight = absoluteHeight;
    }
    
    public final void copy(AbsoluteSize absoluteSize) {
        setAbsoluteWidth(absoluteSize.getAbsoluteWidth());
        setAbsoluteHeight(absoluteSize.getAbsoluteHeight());
    }
    
    public final AbsoluteSize clone() {
        return new AbsoluteSize(this);
    }
}

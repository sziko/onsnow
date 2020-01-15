package com.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

public class SkiResort {

    private String name;

    private String snowHeight;

    private List<SkiSlope> slopes;

    public String getSnowHeight() { return snowHeight; }

    public void setSnowHeight(String snowHeight) { this.snowHeight = snowHeight; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkiSlope> getSlopes() {
        return slopes;
    }

    public void setSlopes(List<SkiSlope> slopes) {
        this.slopes = slopes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

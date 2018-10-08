package com.console.canvas;

public class Point {

    private Integer xAxisValue;
    private Integer yAxisValue;
    private ReservedColors color;

    public Point(Integer xAxisValue, Integer yAxisValue, ReservedColors color) {
        this.xAxisValue = xAxisValue;
        this.yAxisValue = yAxisValue;
        this.color = color;
    }

    public Integer xAxisValue() {
        return xAxisValue;
    }

    public Integer yAxisValue() {
        return yAxisValue;
    }

    public ReservedColors getColor() {
        return color;
    }


}

package com.console.canvas;

import com.console.constants.Texts;
import com.console.exceptions.DrawException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Canvas {

    private List<List<ReservedColors>> values;
    private Integer width;
    private Integer height;

    public Canvas() {
    }

    public void init(Integer width, Integer height) {
        values = new ArrayList<>(width + 2);
        values.add(0, Collections.nCopies(width + 2, ReservedColors.ENDS_COLOR));
        for (int x = 1; x < height + 1; x++) {
            List<ReservedColors> column = new ArrayList<>(Collections.nCopies(width, ReservedColors.NO_COLOR));
            column.add(0, ReservedColors.SIDES_COLOR);
            column.add(width + 1, ReservedColors.SIDES_COLOR);
            values.add(x, column);
        }
        values.add(height + 1, Collections.nCopies(width + 2, ReservedColors.ENDS_COLOR));
        this.height = height;
        this.width = width;
    }

    public void printCanvas() {
        values.stream().forEach(s -> {
            s.stream().forEach(c -> System.out.print(c.getValue()));
            System.out.println();
        });
    }

    public void drawLine(Point start, Point end) throws DrawException {

        if (start.xAxisValue() < 1 || end.xAxisValue() > width || start.yAxisValue() < 1 || end.yAxisValue() > height) {
            throw new DrawException(Texts.DRAW_LINE_POINT_OUT_OF_BOUNDS);
        }

        //vertical line
        if (start.xAxisValue().equals(end.xAxisValue())) {
            for (int index = Math.min(start.yAxisValue(), end.yAxisValue()); index <= Math.max(start.yAxisValue(), end.yAxisValue()); index++) {
                values.get(index).set(start.xAxisValue(), start.getColor());
            }
            return;
        }

        //horizontal line
        if (start.yAxisValue().equals(end.yAxisValue())) {
            for (int index = Math.min(start.xAxisValue(), end.xAxisValue()); index <= Math.max(start.xAxisValue(), end.xAxisValue()); index++) {
                values.get(start.yAxisValue()).set(index, start.getColor());
            }
            return;
        }

        //as far as i can see in the example no diagonal lines are permitted
        throw new DrawException(Texts.DRAW_LINE_POINTS_NOT_IN_LINE);
    }

    public void fill(Point start) {
        values.get(start.yAxisValue()).set(start.xAxisValue(), start.getColor());
        if (start.yAxisValue() < height
                && !values.get(start.yAxisValue() + 1).get(start.xAxisValue()).equals(ReservedColors.LINE_COLOR)
                && !values.get(start.yAxisValue() + 1).get(start.xAxisValue()).equals(start.getColor())) {
            fill(new Point(start.xAxisValue(), start.yAxisValue() + 1, start.getColor()));
        }
        if (start.yAxisValue() > 1
                && !values.get(start.yAxisValue() - 1).get(start.xAxisValue()).equals(ReservedColors.LINE_COLOR)
                && !values.get(start.yAxisValue() - 1).get(start.xAxisValue()).equals(start.getColor())) {
            fill(new Point(start.xAxisValue(), start.yAxisValue() - 1, start.getColor()));
        }
        if (start.xAxisValue() < width
                && !values.get(start.yAxisValue()).get(start.xAxisValue() + 1).equals(ReservedColors.LINE_COLOR)
                && !values.get(start.yAxisValue()).get(start.xAxisValue() + 1).equals(start.getColor())) {
            fill(new Point(start.xAxisValue() + 1, start.yAxisValue(), start.getColor()));
        }
        if (start.xAxisValue() > 1
                && !values.get(start.yAxisValue()).get(start.xAxisValue() - 1).equals(ReservedColors.LINE_COLOR)
                && !values.get(start.yAxisValue()).get(start.xAxisValue() - 1).equals(start.getColor())) {
            fill(new Point(start.xAxisValue() - 1, start.yAxisValue(), start.getColor()));
        }
    }

    public List<List<ReservedColors>> getValues() {
        return values;
    }

    public void setValues(List<List<ReservedColors>> values) {
        this.values = values;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}

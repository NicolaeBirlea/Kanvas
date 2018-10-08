package com.console;


import com.console.canvas.Canvas;
import com.console.canvas.Point;
import com.console.canvas.ReservedColors;
import com.console.exceptions.DrawException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.console.canvas.ReservedColors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CanvasTest {

    private final Integer canvasWidth = 3;
    private final Integer canvasHeight = 4;

    private Canvas canvas = new Canvas();

    @BeforeEach
    private void init() {
        canvas.init(canvasWidth, canvasHeight);
    }

    @Test
    public void testInitCanvas() {
        assertEquals(true, compareCanvasValues(canvas.getValues(), expectedEmptyCanvasValues()));
        assertEquals(canvasHeight, canvas.getHeight());
        assertEquals(canvasWidth, canvas.getWidth());
    }

    @Test
    public void testDrawLineCanvas() {
        try {
            canvas.drawLine(new Point(1, 1, ReservedColors.LINE_COLOR), new Point(1, 2, ReservedColors.LINE_COLOR));
        } catch (DrawException e) {
            assertFalse(true);
        }

        assertEquals(true, compareCanvasValues(canvas.getValues(), expectedLineCanvasValues()));
    }


    @Test
    public void testFillPointCanvas() {
        canvas.fill(new Point(3, 3, ReservedColors.DEFAULT_FILL_COLOR));
        assertEquals(true, compareCanvasValues(canvas.getValues(), expectedFillCanvasValues()));
    }

    //this should be moved
    public static boolean compareCanvasValues(List<List<ReservedColors>> givenValues, List<List<ReservedColors>> expectedValues) {
        System.out.println(givenValues);
        System.out.println(expectedValues);
        for (int indexY = 0; indexY < givenValues.size(); indexY++) {
            for (int indexX = 0; indexX < givenValues.get(indexY).size(); indexX++) {
                if (!givenValues.get(indexY).get(indexX).equals(expectedValues.get(indexY).get(indexX))) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<List<ReservedColors>> expectedEmptyCanvasValues() {
        List<List<ReservedColors>> expectedValues = new ArrayList<>();
        List<ReservedColors> line0 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        List<ReservedColors> line1 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line2 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line3 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line4 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line5 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        expectedValues.add(line0);
        expectedValues.add(line1);
        expectedValues.add(line2);
        expectedValues.add(line3);
        expectedValues.add(line4);
        expectedValues.add(line5);
        return expectedValues;
    }

    private List<List<ReservedColors>> expectedLineCanvasValues() {
        List<List<ReservedColors>> expectedValues = new ArrayList<>();
        List<ReservedColors> line0 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        List<ReservedColors> line1 = Arrays.asList(SIDES_COLOR, LINE_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line2 = Arrays.asList(SIDES_COLOR, LINE_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line3 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line4 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line5 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        expectedValues.add(line0);
        expectedValues.add(line1);
        expectedValues.add(line2);
        expectedValues.add(line3);
        expectedValues.add(line4);
        expectedValues.add(line5);
        return expectedValues;
    }

    private List<List<ReservedColors>> expectedFillCanvasValues() {
        List<List<ReservedColors>> expectedValues = new ArrayList<>();
        List<ReservedColors> line0 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        List<ReservedColors> line1 = Arrays.asList(SIDES_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, SIDES_COLOR);
        List<ReservedColors> line2 = Arrays.asList(SIDES_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, SIDES_COLOR);
        List<ReservedColors> line3 = Arrays.asList(SIDES_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, SIDES_COLOR);
        List<ReservedColors> line4 = Arrays.asList(SIDES_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR, SIDES_COLOR);
        List<ReservedColors> line5 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        expectedValues.add(line0);
        expectedValues.add(line1);
        expectedValues.add(line2);
        expectedValues.add(line3);
        expectedValues.add(line4);
        expectedValues.add(line5);
        return expectedValues;
    }


}


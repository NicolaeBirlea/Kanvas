package com.console.commands;

import com.console.CanvasTest;
import com.console.canvas.Canvas;
import com.console.canvas.ReservedColors;
import com.console.canvas.commands.DrawLineCommand;
import com.console.constants.Texts;
import com.console.exceptions.DrawException;
import com.console.exceptions.IncorrectCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.console.canvas.ReservedColors.*;
import static org.junit.jupiter.api.Assertions.*;

public class DrawLineCommandTest {

    private final Integer canvasWidth = 3;
    private final Integer canvasHeight = 4;

    List<String> incorrectNumberOfParameters = Arrays.asList("1", "3");
    List<String> incorrectValuesForParameters = Arrays.asList("a", "3", "3", "4");
    List<String> parametersOutOfBounds = Arrays.asList("1", "3", "3", "5");
    List<String> diagonalParameters = Arrays.asList("1", "1", "3", "3");
    List<String> correctParameters = Arrays.asList("1", "1", "1", "2");


    private Canvas canvas = new Canvas();

    @BeforeEach
    private void init() {
        canvas.init(canvasWidth, canvasHeight);
    }

    @Test()
    public void testIncorrectNumberOfParameters() {
        Executable drawCommand = () -> new DrawLineCommand(incorrectNumberOfParameters);
        assertEquals(Texts.DRAW_LINE_COMMAND_INCORRECT_NUMBER_PARAMETERS, assertThrows(IncorrectCommandException.class,
                drawCommand).getMessage());
    }

    @Test()
    public void testIncorrectValuesOfParameters() {
        Executable drawCommand = () -> new DrawLineCommand(incorrectValuesForParameters);
        assertEquals(Texts.DRAW_LINE_COMMAND_INCORRECT_PARAMETERS_VALUES, assertThrows(IncorrectCommandException.class,
                drawCommand).getMessage());
    }

    @Test()
    public void testParameterOutOfBounds() {
        Executable drawCommand = () -> new DrawLineCommand(parametersOutOfBounds).command(canvas);
        assertEquals(Texts.DRAW_LINE_POINT_OUT_OF_BOUNDS, assertThrows(DrawException.class,
                drawCommand).getMessage());
    }

    @Test()
    public void testDiagonalPointsParameters() {
        Executable drawCommand = () -> new DrawLineCommand(diagonalParameters).command(canvas);
        assertEquals(Texts.DRAW_LINE_POINTS_NOT_IN_LINE, assertThrows(DrawException.class,
                drawCommand).getMessage());
    }

    @Test
    public void testDrawLineCanvas() {
        try {
            new DrawLineCommand(correctParameters).command(canvas);
        } catch (IncorrectCommandException e) {
            assertFalse(true);
        } catch (DrawException e) {
            assertFalse(true);
        }

        assertEquals(true, CanvasTest.compareCanvasValues(canvas.getValues(), expectedLineCanvasValues()));
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


}

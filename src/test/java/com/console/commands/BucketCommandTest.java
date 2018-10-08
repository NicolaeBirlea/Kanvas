package com.console.commands;

import com.console.CanvasTest;
import com.console.canvas.Canvas;
import com.console.canvas.ReservedColors;
import com.console.canvas.commands.BucketCommand;
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

public class BucketCommandTest {

    private final Integer canvasWidth = 3;
    private final Integer canvasHeight = 4;

    List<String> incorrectNumberOfParameters = Arrays.asList("1", "3", "3", "5");
    List<String> incorrectValuesForParameters = Arrays.asList("a", "3", "3");
    List<String> parametersOutOfBounds = Arrays.asList("1", "7", "o");
    List<String> incorrectColorParameters = Arrays.asList("1", "1", "x");
    List<String> correctParameters = Arrays.asList("1", "1", "o");


    private Canvas canvas = new Canvas();

    @BeforeEach
    private void init() {
        canvas.init(canvasWidth, canvasHeight);
    }

    @Test()
    public void testIncorrectNumberOfParameters() {
        Executable drawCommand = () -> new BucketCommand(incorrectNumberOfParameters);
        assertEquals(Texts.BUCKET_COMMAND_INCORRECT_NUMBER_PARAMETERS, assertThrows(IncorrectCommandException.class,
                drawCommand).getMessage());
    }

    @Test()
    public void testIncorrectValuesOfParameters() {
        Executable drawCommand = () -> new BucketCommand(incorrectValuesForParameters);
        assertEquals(Texts.BUCKET_COMMAND_INCORRECT_PARAMETERS, assertThrows(IncorrectCommandException.class,
                drawCommand).getMessage());
    }

    @Test()
    public void testParameterOutOfBounds() {
        Executable drawCommand = () -> new BucketCommand(parametersOutOfBounds).command(canvas);
        assertEquals(Texts.BUCKET_COMMAND_OUT_OF_BOUNDS_COORDINATES, assertThrows(DrawException.class,
                drawCommand).getMessage());
    }

    @Test()
    public void testIncorrectColorParameters() {
        Executable drawCommand = () -> new BucketCommand(incorrectColorParameters);
        assertEquals(Texts.BUCKET_COMMAND_INCORRECT_COLOR, assertThrows(IncorrectCommandException.class,
                drawCommand).getMessage());
    }

    @Test
    public void testFillCanvas() {
        try {
            new BucketCommand(correctParameters).command(canvas);
        } catch (IncorrectCommandException e) {
            assertFalse(true);
        } catch (DrawException e) {
            assertFalse(true);
        }

        assertEquals(true, CanvasTest.compareCanvasValues(canvas.getValues(), expectedFillCanvasValues()));
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

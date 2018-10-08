package com.console.commands;

import com.console.CanvasTest;
import com.console.canvas.Canvas;
import com.console.canvas.ReservedColors;
import com.console.canvas.commands.CreateCanvasCommand;
import com.console.constants.Texts;
import com.console.exceptions.IncorrectCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.console.canvas.ReservedColors.*;
import static org.junit.jupiter.api.Assertions.*;

public class CreateCanvasCommandTest {

    private final Integer canvasWidth = 3;
    private final Integer canvasHeight = 3;

    List<String> incorrectNumberOfParameters = Arrays.asList("1", "3", "4");
    List<String> incorrectValuesForParameters = Arrays.asList("a", "3");
    List<String> correctParameters = Arrays.asList("3", "3");


    private Canvas canvas = new Canvas();

    @BeforeEach
    private void init() {
        canvas.init(canvasWidth, canvasHeight);
    }

    @Test()
    public void testIncorrectNumberOfParameters() {
        Executable drawCommand = () -> new CreateCanvasCommand(incorrectNumberOfParameters);
        assertEquals(Texts.CREATE_CANVAS_COMMAND_INCORRECT_NUMBER_PARAMETERS, assertThrows(IncorrectCommandException.class,
                drawCommand).getMessage());
    }

    @Test()
    public void testIncorrectValuesOfParameters() {
        Executable drawCommand = () -> new CreateCanvasCommand(incorrectValuesForParameters);
        assertEquals(Texts.CREATE_CANVAS_COMMAND_INCORRECT_PARAMETERS_VALUES, assertThrows(IncorrectCommandException.class,
                drawCommand).getMessage());
    }


    @Test
    public void testCreateCanvas() {
        try {
            new CreateCanvasCommand(correctParameters).command(canvas);
        } catch (IncorrectCommandException e) {
            assertFalse(true);
        }

        assertEquals(true, CanvasTest.compareCanvasValues(canvas.getValues(), expectedEmptyCanvasValues()));
    }


    private List<List<ReservedColors>> expectedEmptyCanvasValues() {
        List<List<ReservedColors>> expectedValues = new ArrayList<>();
        List<ReservedColors> line0 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        List<ReservedColors> line1 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line2 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line3 = Arrays.asList(SIDES_COLOR, NO_COLOR, NO_COLOR, NO_COLOR, SIDES_COLOR);
        List<ReservedColors> line4 = Arrays.asList(ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR, ENDS_COLOR);
        expectedValues.add(line0);
        expectedValues.add(line1);
        expectedValues.add(line2);
        expectedValues.add(line3);
        expectedValues.add(line4);
        return expectedValues;
    }


}

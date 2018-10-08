package com.console.canvas.commands;

import com.console.canvas.Canvas;
import com.console.constants.Texts;
import com.console.exceptions.IncorrectCommandException;

import java.util.ArrayList;
import java.util.List;

public class CreateCanvasCommand implements Commandable {

    List<Integer> parameters;

    public CreateCanvasCommand(List<String> parameters) throws IncorrectCommandException {
        if (parameters.size() != 2) {
            throw new IncorrectCommandException(Texts.CREATE_CANVAS_COMMAND_INCORRECT_NUMBER_PARAMETERS);
        }

        this.parameters = new ArrayList<>();

        try {
            parameters.stream().forEachOrdered(param -> this.parameters.add(Integer.parseInt(param)));
        } catch (NumberFormatException nfe) {
            throw new IncorrectCommandException(Texts.CREATE_CANVAS_COMMAND_INCORRECT_PARAMETERS_VALUES);
        }
    }

    @Override
    public void command(Canvas canvas) {
        canvas.init(parameters.get(0), parameters.get(1));
    }
}

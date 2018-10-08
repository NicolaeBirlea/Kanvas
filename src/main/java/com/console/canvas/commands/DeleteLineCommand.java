package com.console.canvas.commands;

import com.console.canvas.Canvas;
import com.console.canvas.Point;
import com.console.canvas.ReservedColors;
import com.console.constants.Texts;
import com.console.exceptions.DrawException;
import com.console.exceptions.IncorrectCommandException;

import java.util.ArrayList;
import java.util.List;

public class DeleteLineCommand implements Commandable {

    List<Integer> parameters;

    public DeleteLineCommand(List<String> parameters) throws IncorrectCommandException {
        if (parameters.size() != 4) {
            throw new IncorrectCommandException(Texts.DELETE_LINE_COMMAND_INCORRECT_NUMBER_PARAMETERS);
        }

        this.parameters = new ArrayList<>();

        try {
            parameters.stream().forEachOrdered(param -> this.parameters.add(Integer.parseInt(param)));
        } catch (NumberFormatException nfe) {
            throw new IncorrectCommandException(Texts.DELETE_LINE_COMMAND_INCORRECT_PARAMETERS_VALUES);
        }
    }

    @Override
    public void command(Canvas canvas) throws DrawException {
        canvas.drawLine(new Point(parameters.get(0), parameters.get(1), ReservedColors.NO_COLOR),
                new Point(parameters.get(2), parameters.get(3), ReservedColors.NO_COLOR));
    }
}

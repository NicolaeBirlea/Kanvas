package com.console.canvas.commands;

import com.console.canvas.Canvas;
import com.console.canvas.Point;
import com.console.canvas.ReservedColors;
import com.console.constants.Texts;
import com.console.exceptions.DrawException;
import com.console.exceptions.IncorrectCommandException;

import java.util.ArrayList;
import java.util.List;

public class BucketCommand implements Commandable {

    List<Integer> parameters;
    ReservedColors color;

    public BucketCommand(List<String> parameters) throws IncorrectCommandException {
        if (parameters.size() < 2 || parameters.size() > 3) {
            throw new IncorrectCommandException(Texts.BUCKET_COMMAND_INCORRECT_NUMBER_PARAMETERS);
        }

        this.parameters = new ArrayList<>();

        try {
            this.parameters.add(Integer.parseInt(parameters.get(0)));
            this.parameters.add(Integer.parseInt(parameters.get(1)));
        } catch (NumberFormatException nfe) {
            throw new IncorrectCommandException(Texts.BUCKET_COMMAND_INCORRECT_PARAMETERS);
        }

        if (parameters.size() == 2) {
            color = ReservedColors.NO_COLOR;
            return;
        }

        if ("|-x".contains(parameters.get(2))) {
            throw new IncorrectCommandException(Texts.BUCKET_COMMAND_INCORRECT_COLOR);
        }

        if (parameters.get(2).length() != 1) {
            throw new IncorrectCommandException(Texts.BUCKET_COMMAND_INCORRECT_COLOR);
        }

        color = ReservedColors.getByValue(parameters.get(2).charAt(0));
    }

    @Override
    public void command(Canvas canvas) throws DrawException {
        if (parameters.get(0) < 1 || parameters.get(0) > canvas.getWidth() || parameters.get(1) < 1 || parameters.get(1) > canvas.getHeight()) {
            throw new DrawException(Texts.BUCKET_COMMAND_OUT_OF_BOUNDS_COORDINATES);
        }
        if (canvas.getValues().get(parameters.get(1)).get(parameters.get(0)).equals(ReservedColors.LINE_COLOR)) {
            throw new DrawException(Texts.BUCKET_COMMAND_INCORRECT_STARTING_POINT);
        }
        canvas.fill(new Point(parameters.get(0), parameters.get(1), color));
    }
}

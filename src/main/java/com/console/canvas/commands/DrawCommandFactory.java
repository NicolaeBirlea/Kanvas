package com.console.canvas.commands;

import com.console.constants.Texts;
import com.console.exceptions.IncorrectCommandException;

import java.util.Arrays;
import java.util.List;

public class DrawCommandFactory {

    public static Commandable getCommand(String commandLine) throws IncorrectCommandException {
        //small check to see it if follows basic command rules.
        if (!commandLine.matches("[LRBHCQD]+[[\\s]+[0-9]*]*[[\\s]+[a-z]*]*")) {
            throw new IncorrectCommandException(Texts.GENERAL_INCORRECT_COMMAND);
        }
        List<String> parameters = Arrays.asList(commandLine.split("\\s+"));
        String commandCode = parameters.get(0);
        return buildCommand(commandCode, parameters.subList(1, parameters.size()));
    }

    private static Commandable buildCommand(String command, List<String> parameters) throws IncorrectCommandException {
        switch (CommandType.get(command)) {
            case CANVAS:
                return new CreateCanvasCommand(parameters);
            case LINE:
                return new DrawLineCommand(parameters);
            case RECTANGLE:
                return new DrawRectangleCommand(parameters);
            case BUCKET:
                return new BucketCommand(parameters);
            case DELETE:
                return new DeleteLineCommand(parameters);
        }
        throw new IncorrectCommandException(Texts.NOT_ACCEPTED_COMMAND);
    }

}

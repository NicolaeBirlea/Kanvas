package com.console;

import com.console.canvas.Canvas;
import com.console.canvas.commands.CommandType;
import com.console.canvas.commands.Commandable;
import com.console.canvas.commands.DrawCommandFactory;
import com.console.constants.Texts;
import com.console.exceptions.DrawException;
import com.console.exceptions.IncorrectCommandException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");

        System.out.print(Texts.WELCOME_MESSAGE);
        String command = "";
        Canvas canvas = new Canvas();

        while (true) {
            command = scanner.nextLine().trim();

            if (command.equals(CommandType.QUIT.getCode())) {
                break;
            }

            if (command.equals(CommandType.HELP.getCode())) {
                System.out.println(Texts.HELP_TEXT);
                continue;
            }

            try {
                Commandable commandObject = DrawCommandFactory.getCommand(command);
                commandObject.command(canvas);
                canvas.printCanvas();
            } catch (IncorrectCommandException e) {
                System.out.println(e.getMessage());
            } catch (DrawException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}

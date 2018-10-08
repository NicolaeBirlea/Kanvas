package com.console.constants;

public interface Texts {

    public static final String HELP_TEXT = "C w h\t Creates a new canvas of width w and height h.\n" +
            "L x1 y1 x2 y2\t Creates a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the x character.\n" +
            "R x1 y1 x2 y2\t Creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the x character.\n" +
            "B x y c\t Fills the entire area connected to (x,y) with colour 'c'. The behaviour of this is the same as that of the \"bucket fill\" tool in paint programs.\n" +
            "Q\t Quits the program.";

    public static final String BUCKET_COMMAND_INCORRECT_NUMBER_PARAMETERS = "the bucket Fill command should have 3 parameters.";
    public static final String BUCKET_COMMAND_INCORRECT_PARAMETERS = "the bucket Fill command should have 2 numeric.";
    public static final String BUCKET_COMMAND_OUT_OF_BOUNDS_COORDINATES = "the bucket Fill command needs the correct numeric coordinates for a starting point.";
    public static final String BUCKET_COMMAND_INCORRECT_COLOR = "the bucket Fill color should be different from lines or edges";
    public static final String BUCKET_COMMAND_INCORRECT_STARTING_POINT = "the bucket Fill command should not start from an existing line";

    public static final String CREATE_CANVAS_COMMAND_INCORRECT_NUMBER_PARAMETERS = "the Create canvas line command should have 2 parameters.";
    public static final String CREATE_CANVAS_COMMAND_INCORRECT_PARAMETERS_VALUES = "the Create canvas command should only integer parameters.";

    public static final String DELETE_LINE_COMMAND_INCORRECT_NUMBER_PARAMETERS = "the Delete line command should have 4 parameters.";
    public static final String DELETE_LINE_COMMAND_INCORRECT_PARAMETERS_VALUES = "the Delete line command should only integer parameters.";

    public static final String DRAW_LINE_COMMAND_INCORRECT_NUMBER_PARAMETERS = "the Draw line command should have 4 parameters.";
    public static final String DRAW_LINE_COMMAND_INCORRECT_PARAMETERS_VALUES = "the Draw line command should only integer parameters.";

    public static final String DRAW_RECTANGLE_COMMAND_INCORRECT_NUMBER_PARAMETERS = "the Draw rectangle command should have 4 parameters.";
    public static final String DRAW_RECTANGLE_COMMAND_INCORRECT_PARAMETERS_VALUES = "the Draw rectangle command should only have integer parameters.";

    public static final String GENERAL_INCORRECT_COMMAND = "Incorrect command please press H for a description of available commands";
    public static final String NOT_ACCEPTED_COMMAND = "Could not execute any command for the given input!";

    public static final String WELCOME_MESSAGE = "Start your Canvas: \n ";

    public static final String DRAW_LINE_POINT_OUT_OF_BOUNDS = "line/rectangle ends must be in the canvas space";
    public static final String DRAW_LINE_POINTS_NOT_IN_LINE = "we cannot draw diagonal lines";


}

package com.console.canvas.commands;

public enum CommandType {

    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET("B"),
    QUIT("Q"),
    HELP("H"),
    DELETE("D");

    private String code;

    public String getCode() {
        return this.code;
    }

    CommandType(String code) {
        this.code = code;
    }

    public static CommandType get(String code) {
        for (CommandType e : CommandType.values()) {
            if (code.equals(e.code)) {
                return e;
            }
        }
        return null;
    }

}

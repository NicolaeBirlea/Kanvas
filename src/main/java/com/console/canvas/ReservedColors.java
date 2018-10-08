package com.console.canvas;

public enum ReservedColors {
    NO_COLOR(' '),
    LINE_COLOR('x'),
    SIDES_COLOR('|'),
    ENDS_COLOR('-'),
    DEFAULT_FILL_COLOR('o'),
    EXAMPLE_FILL_COLOR('v');

    private Character color;

    public Character getValue() {
        return this.color;
    }

    ReservedColors(Character code) {
        this.color = code;
    }

    public static ReservedColors getByValue(Character colorValue) {
        for (ReservedColors e : ReservedColors.values()) {
            if (e.color.equals(colorValue)) {
                return e;
            }
        }
        return DEFAULT_FILL_COLOR;// not found
    }
}

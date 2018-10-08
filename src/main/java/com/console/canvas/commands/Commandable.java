package com.console.canvas.commands;

import com.console.canvas.Canvas;
import com.console.exceptions.DrawException;

public interface Commandable {

    public void command(Canvas canvas) throws DrawException;

}

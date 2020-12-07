package com.epam.jwd.exception;

import com.epam.jwd.figures.model.point.Point;

public abstract class FigureException extends Exception {

    public FigureException(String message){
        super(message);
    }

    public abstract void logException(String message);
}

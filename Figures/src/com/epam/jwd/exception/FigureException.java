package com.epam.jwd.exception;

import com.epam.jwd.figures.model.point.Point;

public abstract class FigureException extends Exception {

    private Point point;

    public Point getPoint() {
        return point;
    }

    public FigureException(String message, Point point){
        super(message);
        this.point = point;
    }

    public abstract void logException(String message);
}

package com.epam.jwd.service.api;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigurePointsException;
import com.epam.jwd.figures.model.point.Point;

public interface FigurePreProcessor {
    boolean preProcess(Point[] points) throws FigurePointsException;
    static boolean process(Point[] points) {
        return false;
    }
}
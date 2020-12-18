package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigurePointsException;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.service.PointService;
import com.epam.jwd.service.api.FigurePreProcessor;

public class FigurePointCheckPreProcessor implements FigurePreProcessor {

    @Override
    public boolean preProcess(Point[] points) throws FigurePointsException {
        if (!isPointsAreDifferent(points)) {
            throw new FigurePointsException("Figure cannot be exist");
        }

        return true;
    }

    public static boolean process(Point[] points) throws FigurePointsException {
        if (!isPointsAreDifferent(points)) {
            throw new FigurePointsException("Figure cannot be exist");
        }

        return true;
    }

    public static boolean isPointsAreDifferent(Point[] points) {
        return PointService.isPointsAreDifferent(points);
    }
}

package com.epam.jwd.figures.model.square;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.service.api.FigureFactory;

public class SquareFigureFactory implements FigureFactory {

    public static final int COUNT_OF_POINTS = 4;

    @Override
    public Figure create(Point[] points) {
        return new Square(points[0], points[1], points[2], points[3]);
    }
}
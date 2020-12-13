package com.epam.jwd.figures.model.triangle;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.service.api.FigureFactory;

public class TriangleFigureFactory implements FigureFactory {

    public static final int COUNT_OF_POINTS = 3;

    @Override
    public Figure create(Point[] points) {
        return new Triangle(points[0], points[1], points[2]);
    }
}
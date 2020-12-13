package com.epam.jwd.figures.model.multiangle;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.service.api.FigureFactory;

public class MultiAngleFigureFactory implements FigureFactory {

    public static final int COUNT_OF_POINTS = 6;

    @Override
    public Figure create(Point[] points) {
        return new MultiAngleFigure(COUNT_OF_POINTS, points);
    }
}

package com.epam.jwd.figures.strategy;

import com.epam.jwd.figures.model.point.Point;

public interface FigureStrategyInterface {

    double calculatePerimeter(Point[] points);
    double calculateArea(Point[] points);
}

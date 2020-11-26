package com.epam.jwd.figures.strategy;

import com.epam.jwd.figures.model.Point;

public interface FigureStrategyInterface {

    public double calculatePerimeter(Point[] points);
    public double calculateArea(Point[] points);
}

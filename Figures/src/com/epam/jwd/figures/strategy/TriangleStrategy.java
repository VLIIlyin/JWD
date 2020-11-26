package com.epam.jwd.figures.strategy;

import com.epam.jwd.figures.model.Point;
import com.epam.jwd.figures.service.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum TriangleStrategy implements FigureStrategyInterface {
    TRIANGLE;

    final static Logger Logger = LogManager.getLogger(TriangleStrategy.class);

    @Override
    public double calculatePerimeter(Point[] points) {
        return PointService.intervalBetweenPoints(points[0], points[1])
                + PointService.intervalBetweenPoints(points[1], points[2])
                + PointService.intervalBetweenPoints(points[2], points[0]);
    }

    @Override
    public double calculateArea(Point[] points) {
        Logger.info("Area calculated with help of triangle strategy");
        double compositionOfHalfPerimeterWithSides = calculateCompositionOfHalfPerimeterWithSides(points);
        return Math.sqrt(compositionOfHalfPerimeterWithSides < 0
                ? compositionOfHalfPerimeterWithSides * -1
                : compositionOfHalfPerimeterWithSides);
    }

    private double calculateCompositionOfHalfPerimeterWithSides(Point[] points) {
        return calculateHalfPerimeter(points)
                * calculateHalfPerimeter(points) - PointService.intervalBetweenPoints(points[0], points[1])
                * calculateHalfPerimeter(points) - PointService.intervalBetweenPoints(points[1], points[2])
                * calculateHalfPerimeter(points) - PointService.intervalBetweenPoints(points[2], points[0]);
    }

    private double calculateHalfPerimeter(Point[] points) {
        return calculatePerimeter(points) / 2;
    }
}

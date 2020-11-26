package com.epam.jwd.figures.strategy;

import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.service.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareStrategy implements FigureStrategyInterface {

    static final Logger LOGGER = LogManager.getLogger(SquareStrategy.class);

    private SquareStrategy() {

    }

    public static SquareStrategy getInstance(){
        return SquareStrategyHolder.INSTANCE;
    }

    @Override
    public double calculatePerimeter(Point[] points) {
        LOGGER.info("Perimeter calculated with help of square strategy");
        return PointService.intervalBetweenPoints(points[0], points[1]) * 4;
    }

    @Override
    public double calculateArea(Point[] points) {
        LOGGER.info("Area calculated with help of square strategy");
        return Math.pow(PointService.intervalBetweenPoints(points[0], points[1]), 2);
    }

    private static class SquareStrategyHolder {

        private static final SquareStrategy INSTANCE = new SquareStrategy();
    }
}

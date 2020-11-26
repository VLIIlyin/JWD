package com.epam.jwd.figures.model;

import com.epam.jwd.figures.service.PointService;
import com.epam.jwd.figures.strategy.TriangleStrategy;

public class Triangle extends Figure {

    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;

        Figure.setFigureStrategyInterface(TriangleStrategy.TRIANGLE);
    }

    public boolean isFigureCanExist() {
        return isPointsAreDifferent()
                && isSumOfSideCorrect();
    }

    public boolean isPointsAreDifferent() {
        return !(this.getFirstPoint().equals(getSecondPoint())
                || this.getFirstPoint().equals(getThirdPoint())
                || this.getSecondPoint().equals(getThirdPoint()));
    }

    private Double[] intervals() {
        return new Double[]{PointService.intervalBetweenPoints(getFirstPoint(), getSecondPoint()),
                PointService.intervalBetweenPoints(getSecondPoint(), getThirdPoint()),
                PointService.intervalBetweenPoints(getThirdPoint(), getFirstPoint())};
    }

    private Double[] sides() {
        return sides(intervals());
    }

    private Double[] sides(Double[] intervals) {
        return new Double[]{intervals[0] + intervals[1],
                intervals[0] + intervals[2],
                intervals[1] + intervals[2]};
    }

    public boolean isSumOfSideCorrect() {

        Double[] intervals = intervals();
        Double[] sides = sides(intervals);

        return sides[0] > intervals[2]
                && sides[1] > intervals[1]
                && sides[2] > intervals[0];
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    @Override
    public String toString() {
        return "Triangle {" +
                "firstPoint = " + firstPoint +
                ", secondPoint = " + secondPoint +
                ", thirdPoint = " + thirdPoint +
                '}';
    }
}

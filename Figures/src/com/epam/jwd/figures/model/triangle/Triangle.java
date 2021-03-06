package com.epam.jwd.figures.model.triangle;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
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

    private Double[] sidesSum() {
        return sidesSum(intervals());
    }

    private Double[] sidesSum(Double[] intervals) {
        return new Double[]{intervals[0] + intervals[1],
                intervals[0] + intervals[2],
                intervals[1] + intervals[2]};
    }

    public boolean isSumOfSideCorrect() {
        Double[] intervals = intervals();
        Double[] sidesSum = sidesSum(intervals);

        return sidesSum[0] > intervals[2]
                && sidesSum[1] > intervals[1]
                && sidesSum[2] > intervals[0];
    }

    private double calculateCompositionOfHalfPerimeterWithSides() {
        return calculateHalfPerimeter()
                * calculateHalfPerimeter() - PointService.intervalBetweenPoints(firstPoint, secondPoint)
                * calculateHalfPerimeter() - PointService.intervalBetweenPoints(secondPoint, thirdPoint)
                * calculateHalfPerimeter() - PointService.intervalBetweenPoints(thirdPoint, firstPoint);
    }

    public double calculatePerimeter() {
        return PointService.intervalBetweenPoints(firstPoint, secondPoint)
                + PointService.intervalBetweenPoints(secondPoint, thirdPoint)
                + PointService.intervalBetweenPoints(thirdPoint, firstPoint);
    }

    private double calculateHalfPerimeter() {
        return calculatePerimeter() / 2;
    }

    public double calculateArea() {
        double compositionOfHalfPerimeterWithSides = calculateCompositionOfHalfPerimeterWithSides();
        return Math.sqrt(compositionOfHalfPerimeterWithSides < 0
                ? compositionOfHalfPerimeterWithSides * -1
                : compositionOfHalfPerimeterWithSides);
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

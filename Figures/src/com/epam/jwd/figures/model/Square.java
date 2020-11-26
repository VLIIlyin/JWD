package com.epam.jwd.figures.model;

import com.epam.jwd.figures.service.PointService;
import com.epam.jwd.figures.strategy.SquareStrategy;
import com.epam.jwd.figures.strategy.TriangleStrategy;

import java.util.Objects;

public class Square extends Figure {

    private final Point firstPoint;
    private final Point secondPoint;
    private final Point thirdPoint;
    private final Point fourthPoint;

    public Square(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        this.fourthPoint = fourthPoint;

        Figure.setFigureStrategyInterface(SquareStrategy.getInstance());
    }

    public boolean isFigureCanExist() {
        return isPointsAreDifferent()
                && isSumOfSideCorrect();
    }

    public boolean isPointsAreDifferent() {
        return !(getFirstPoint().equals(getSecondPoint())
                || getFirstPoint().equals(getThirdPoint())
                || getFirstPoint().equals(getFourthPoint())
                || getSecondPoint().equals(getThirdPoint())
                || getSecondPoint().equals(getFourthPoint())
                || getThirdPoint().equals(getFourthPoint()));
    }

    private Double[] intervals() {
        return new Double[]{PointService.intervalBetweenPoints(getFirstPoint(), getSecondPoint()),
                PointService.intervalBetweenPoints(getSecondPoint(), getThirdPoint()),
                PointService.intervalBetweenPoints(getThirdPoint(), getFourthPoint()),
                PointService.intervalBetweenPoints(getFourthPoint(), getFirstPoint())};
    }

    private Double[] sides() {
        return sides(intervals());
    }

    private Double[] sides(Double[] intervals) {
        return new Double[]{intervals[0] + intervals[1],
                intervals[1] + intervals[2],
                intervals[2] + intervals[3],
                intervals[3] + intervals[0]};
    }

    public boolean isSumOfSideCorrect() {

        Double[] intervals = intervals();
        Double[] sides = sides(intervals);

        return sides[0].equals(sides[1])
                && sides[1].equals(sides[2])
                && sides[2].equals(sides[3])
                && sides[0].equals(sides[3]);
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

    public Point getFourthPoint() {
        return fourthPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(firstPoint, square.firstPoint) &&
                Objects.equals(secondPoint, square.secondPoint) &&
                Objects.equals(thirdPoint, square.thirdPoint) &&
                Objects.equals(fourthPoint, square.fourthPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint, thirdPoint, fourthPoint);
    }

    @Override
    public String toString() {
        return "Square {" +
                "firstPoint = " + firstPoint +
                ", secondPoint = " + secondPoint +
                ", thirdPoint = " + thirdPoint +
                ", fourthPoint = " + fourthPoint +
                '}';
    }
}

package com.epam.jwd.figures.model.multiangle;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.service.PointService;

import java.util.Arrays;
import java.util.Objects;

class MultiAngleFigure extends Figure {

    private final int countOfPoints;
    private final Point[] points;

    public MultiAngleFigure(int countOfPoints, Point[] points) {
        this.countOfPoints = countOfPoints;
        this.points = points;
    }

    public boolean isFigureCanExist() {
        return isPointsAreDifferent()
                && isSumOfSideCorrect();
    }

    public boolean isPointsAreDifferent() {
        for (int i = 0; i < points.length; i++) {
            for (int k = i + 1; k < points.length; k++) {
                if (points[i].equals(points[k])) {
                    return false;
                }
            }
        }

        return true;
    }

    private Double[] intervals() {
        Double[] intervals = new Double[points.length];

        for (int i = 0; i < points.length - 1; i++) {
            intervals[i] = PointService.intervalBetweenPoints(points[i], points[i + 1]);
        }

        intervals[points.length - 1] = PointService.intervalBetweenPoints(points[points.length - 1], points[0]);

        return intervals;
    }

    private Double[] sidesSum() {
        return sidesSum(intervals());
    }

    private Double[] sidesSum(Double[] intervals) {
        Double[] sideSum = new Double[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            sideSum[i] = 0.0;
            for (int k = 0; k < intervals.length; k++) {
                if (i != k) {
                    sideSum[i] += intervals[k];
                }
            }
        }

        return sideSum;
    }

    public boolean isSumOfSideCorrect() {

        Double[] intervals = intervals();
        Double[] sides = sidesSum(intervals);

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] > sides[i]) {
                return false;
            }
        }

        return true;
    }

    public int getCountOfPoints() {
        return countOfPoints;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiAngleFigure that = (MultiAngleFigure) o;
        return countOfPoints == that.countOfPoints &&
                Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(countOfPoints);
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "MultiAngleFigure {" +
                "countOfPoints = " + countOfPoints +
                ", points = " + Arrays.toString(points) +
                '}';
    }
}

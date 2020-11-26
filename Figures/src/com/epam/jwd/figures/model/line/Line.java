package com.epam.jwd.figures.model.line;

import com.epam.jwd.figures.model.point.Point;

import java.util.Objects;

class Line {

    private final Point firstPoint;
    private final Point secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public boolean isFigureCanExist() {
        return !this.getFirstPoint().equals(this.getSecondPoint());
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(firstPoint, line.firstPoint) &&
                Objects.equals(secondPoint, line.secondPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPoint, secondPoint);
    }

    @Override
    public String toString() {
        return "Line {" +
                "firstPoint = " + firstPoint +
                ", secondPoint = " + secondPoint +
                '}';
    }
}

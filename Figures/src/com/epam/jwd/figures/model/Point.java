package com.epam.jwd.figures.model;

import java.util.Objects;

public class Point {

    private final double coordX;
    private final double coordY;

    public Point(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.coordX, coordX) == 0 &&
                Double.compare(point.coordY, coordY) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordX, coordY);
    }

    @Override
    public String toString() {
        return "Point {" +
                "coordinate X = " + coordX +
                ", coordinate Y = " + coordY +
                '}';
    }
}

package com.epam.jwd.figures.model.triangle;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.model.point.PointFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class TriangleFactory {

    static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);
    static boolean objectTriangleCreated;

    public static void createAndPrintTriangle() {
        Triangle[] triangles = createTriangleArrayFromPoints();

        if (objectTriangleCreated) {
            printInfoAboutTriangles(triangles);
        } else {
            LOGGER.error("Triangle object was no created");
        }
    }

    private static Triangle[] createTriangleArrayFromPoints() {
        return new Triangle[]{createTriangleFromThreeFirstPoints(PointFactory.generateRandomArray()),
                createTriangleFromThreeFirstPoints(PointFactory.generateRandomArray())};
    }

    private static Triangle createTriangleFromThreeFirstPoints(Point[] points) {
        if (points.length >= 3) {
            Point[] pointsForTriangle = new Point[3];
            int counter = 3;

            System.arraycopy(points, 0, pointsForTriangle, 0, counter);

            objectTriangleCreated = true;
            LOGGER.info("Triangle object created from first three points of array");

            return new Triangle(pointsForTriangle[0], pointsForTriangle[1], pointsForTriangle[2]);
        } else {
            LOGGER.error("Triangle object cannot be created because number of points less than 3");

            return null;
        }
    }

    private static void printInfoAboutTriangles(Triangle[] triangles) {
        for (Triangle triangle : triangles) {
            printInfoAboutTriangle(triangle);
        }
    }

    private static void printInfoAboutTriangle(Triangle triangle) {
        if (triangle.isPointsAreDifferent()) {
            if (triangle.isSumOfSideCorrect()) {
                LOGGER.info(triangle);
                printCalculatedPerimeter(triangle);
                printCalculatedArea(triangle);
            } else {
                LOGGER.error(String.format(Locale.US, "Triangle with next points: %s %s %s cannot exist",
                        triangle.getFirstPoint(),
                        triangle.getSecondPoint(),
                        triangle.getThirdPoint()));
            }
        } else {
            LOGGER.error(String.format(Locale.US, "Object %s is not triangle", triangle));
        }
    }

    private static void printCalculatedPerimeter(Triangle triangle) {
        LOGGER.info("Perimeter calculated with help of triangle strategy");
        LOGGER.info(String.format("Perimeter = %s ",
                Figure.getFigureStrategyInterface(triangle).calculatePerimeter(new Point[]{
                        triangle.getFirstPoint(),
                        triangle.getSecondPoint(),
                        triangle.getThirdPoint()})));
    }

    private static void printCalculatedArea(Triangle triangle) {
        LOGGER.info(String.format("Area = %s",
                Figure.getFigureStrategyInterface(triangle).calculateArea(new Point[]{
                        triangle.getFirstPoint(),
                        triangle.getSecondPoint(),
                        triangle.getThirdPoint()})));
    }
}

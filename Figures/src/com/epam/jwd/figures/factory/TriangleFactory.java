package com.epam.jwd.figures.factory;

import com.epam.jwd.figures.model.Point;
import com.epam.jwd.figures.model.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class TriangleFactory {

    final static Logger Logger = LogManager.getLogger(TriangleFactory.class);
    static boolean objectTriangleCreated;

    public static void createAndPrintTriangle() {
        Triangle[] triangles = createTriangleArrayFromPoints();

        if (objectTriangleCreated) {
            printInfoAboutTriangles(triangles);
        } else {
            Logger.error("Triangle object was no created");
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
            Logger.info("Triangle object created from first three points of array");

            return new Triangle(pointsForTriangle[0], pointsForTriangle[1], pointsForTriangle[2]);
        } else {
            Logger.error("Triangle object cannot be created because number of points less than 3");

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
                Logger.info(triangle);
            } else {
                Logger.error(String.format(Locale.US, "Triangle with next points: %s %s %s cannot exist",
                        triangle.getFirstPoint(),
                        triangle.getSecondPoint(),
                        triangle.getThirdPoint()));
            }
        } else {
            Logger.error(String.format(Locale.US, "Object %s is not triangle", triangle));
        }
    }
}

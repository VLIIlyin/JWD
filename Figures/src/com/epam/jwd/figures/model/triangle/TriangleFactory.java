package com.epam.jwd.figures.model.triangle;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigurePointCheckPreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class TriangleFactory {

    static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);
    static boolean objectTriangleCreated;

    public static void createAndPrintTriangle(int arrayLength) throws FigureNotExistException {
        Triangle[] triangles = createTriangleArrayFromPoints(arrayLength);

        if (objectTriangleCreated) {
            printInfoAboutTriangles(triangles);
        } else {
            LOGGER.error("Triangle object was no created");
        }
    }

    private static Triangle[] createTriangleArrayFromPoints(int arrayLength) {
        Triangle[] triangles = new Triangle[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            triangles[i] = createTriangleFromThreeFirstPoints(PointFactory.generateRandomArray());
        }

        return triangles;
    }

    private static Triangle createTriangleFromThreeFirstPoints(Point[] points) {
        if (points.length >= 3) {
            Point[] pointsForTriangle = new Point[3];
            int counter = 3;
            System.arraycopy(points, 0, pointsForTriangle, 0, counter);
            if (FigurePointCheckPreProcessor.process(points)) {
                objectTriangleCreated = true;
                LOGGER.info("Triangle object created from first three points of array");
                return new Triangle(pointsForTriangle[0], pointsForTriangle[1], pointsForTriangle[2]);
            }
            else{
                LOGGER.error("Triangle object cannot be created because some of points are the same");
                return null;
            }
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
        if (FigureExistencePostProcessor.process(triangle)) {
            LOGGER.info(triangle);
            printCalculatedPerimeter(triangle);
            printCalculatedArea(triangle);
        } else {
            LOGGER.error(String.format(Locale.US, "Triangle with next points: %s %s %s cannot exist",
                    triangle.getFirstPoint(),
                    triangle.getSecondPoint(),
                    triangle.getThirdPoint()));
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

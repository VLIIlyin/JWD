package com.epam.jwd.figures.model.point;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class PointFactory {

    static final Logger LOGGER = LogManager.getLogger(PointFactory.class);

    public static void createAndPrintPointArray(){
        printInfoAboutPoint(generateRandomArray());
    }

    public static Point[] generateRandomArray(){
        Point[] points = {new Point(generateRandomCoord(), generateRandomCoord()),
                new Point(generateRandomCoord(), generateRandomCoord()),
                new Point(generateRandomCoord(), generateRandomCoord()),
                new Point(generateRandomCoord(), generateRandomCoord())};

        LOGGER.info("Array of points created");

        return points;
    }

    public static Point[] generateRandomArrayForFigure(int countOfPoints){
        Point[] points = new Point[countOfPoints];
        int counter = 0;

        while (counter < points.length){
            points[counter] = new Point(generateRandomCoord(), generateRandomCoord());
            counter++;
        }

        return points;
    }

    private static double generateRandomCoord(){
        Random random = new Random();
        return 1 + random.nextDouble() * 30;
    }

    private static void printInfoAboutPoint(Point[] points){
        int numerator = 0;

        do{
            LOGGER.info(points[numerator]);
            numerator++;
        }
        while(numerator < points.length);
    }
}

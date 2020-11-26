package com.epam.jwd.figures.factory;

import com.epam.jwd.figures.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class PointFactory {

    final static Logger Logger = LogManager.getLogger(PointFactory.class);

    public static void createAndPrintPointArray(){
        printInfoAboutPoint(generateRandomArray());
    }

    public static Point[] generateRandomArray(){
        Point[] points = {new Point(generateRandomCoord(), generateRandomCoord()),
                new Point(generateRandomCoord(), generateRandomCoord()),
                new Point(generateRandomCoord(), generateRandomCoord()),
                new Point(generateRandomCoord(), generateRandomCoord())};

        Logger.info("Array of points created");

        return points;
    }

    private static double generateRandomCoord(){
        Random random = new Random();
        return 1 + random.nextDouble() * 30;
    }

    private static void printInfoAboutPoint(Point[] points){
        int numerator = 0;

        do{
            Logger.info(points[numerator]);
            numerator++;
        }
        while(numerator < points.length);
    }
}

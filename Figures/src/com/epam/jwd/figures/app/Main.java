package com.epam.jwd.figures.app;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.figures.model.line.LineFactory;
import com.epam.jwd.figures.model.multiangle.MultiAngleFactory;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.figures.model.square.SquareFactory;
import com.epam.jwd.figures.model.triangle.TriangleFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Main {

    final static Logger Logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Logger.info("Application started");

        PointFactory.createAndPrintPointArray();

        try {
            LineFactory.createAndPrintLineArray(2);
            TriangleFactory.createAndPrintTriangle(3);
            SquareFactory.createAndPrintSquare();
        } catch (FigureNotExistException e) {
            e.logException(e.getMessage());
        }

        createMultiAngles();

        Logger.info("Application ended");
    }

    private static void createMultiAngles() {
        Random random = new Random();
        int randomValue = random.nextInt(MultiAngleFactory.MAX_RANDOM_VALUE
                - MultiAngleFactory.MIN_RANDOM_VALUE + 1);
        try {
            MultiAngleFactory.createAndPrintFigure(randomValue
                            + MultiAngleFactory.MIN_RANDOM_VALUE / 2,
                    randomValue + MultiAngleFactory.MIN_RANDOM_VALUE);
        } catch (FigureNotExistException e) {
            e.logException(e.getMessage());
        }
    }
}

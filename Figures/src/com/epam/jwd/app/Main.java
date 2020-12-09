package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.figures.model.line.LineFactory;
import com.epam.jwd.figures.model.multiangle.MultiAngleFactory;
import com.epam.jwd.figures.model.multiangle.MultiAngleFigureFactory;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.figures.model.square.SquareFactory;
import com.epam.jwd.figures.model.triangle.TriangleFactory;
import com.epam.jwd.service.api.AppContext;
import com.epam.jwd.service.api.FigureFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws FigureException {

        LOGGER.info("Application started");

        final int MIN_RANDOM_VALUE = 4;
        final int MAX_RANDOM_VALUE = 6;
        final AppContext appContext = new MultiAngleAppContext();
        final FigureFactory figureFactory = appContext.createFigureFactory();
        figureFactory.create(PointFactory.generateRandomArrayForFigure(MultiAngleFigureFactory.COUNT_OF_POINTS));

        PointFactory.createAndPrintPointArray();

        LineFactory.createAndPrintLineArray(2);
        TriangleFactory.createAndPrintTriangle(3);
        SquareFactory.createAndPrintSquare();

        createMultiAngles();

        LOGGER.info("Application ended");

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
            LOGGER.error(e.getMessage());
        }
    }
}

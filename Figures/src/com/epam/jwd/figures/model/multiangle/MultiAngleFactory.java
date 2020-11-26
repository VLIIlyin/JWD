package com.epam.jwd.figures.model.multiangle;

import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.model.point.PointFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;
import java.util.Random;

public class MultiAngleFactory {

    static final int MIN_RANDOM_VALUE = 4;
    static final int MAX_RANDOM_VALUE = 6;
    static final Logger LOGGER = LogManager.getLogger(MultiAngleFactory.class);

    public static void createAndPrintFigure() {
        Random random = new Random();
        int randomValue = random.nextInt(MAX_RANDOM_VALUE - MIN_RANDOM_VALUE + 1);
        MultiAngleFigure[] figures = createFigure(randomValue + MIN_RANDOM_VALUE / 2,
                randomValue + MIN_RANDOM_VALUE);
        printInfoAboutFigures(figures);
    }

    private static MultiAngleFigure[] createFigure(int countOfFigures, int countOfPoints) {
        MultiAngleFigure[] multiAngleFigures = new MultiAngleFigure[countOfFigures];

        for (int i = 0; i < countOfFigures; i++) {
            Point[] pointsForMultiAngleFigure = PointFactory.generateRandomArrayForFigure(countOfPoints);

            multiAngleFigures[i] = new MultiAngleFigure(countOfPoints, pointsForMultiAngleFigure);
            LOGGER.info(String.format("Figure object created with number of points = %d", countOfPoints));
        }

        return multiAngleFigures;
    }

    private static void printInfoAboutFigures(MultiAngleFigure[] multiAngleFigures){
        for (MultiAngleFigure multiAngleFigure : multiAngleFigures) {
            printInfoAboutFigure(multiAngleFigure);
        }
    }

    private static void printInfoAboutFigure(MultiAngleFigure multiAngleFigure){
        if (multiAngleFigure.isPointsAreDifferent()) {
            if (multiAngleFigure.isSumOfSideCorrect()) {
                LOGGER.info(multiAngleFigure);
            } else {
                LOGGER.error("Figure cannot exist");
            }
        } else {
            LOGGER.error("Some of points in this figure are equals");
        }
    }
}

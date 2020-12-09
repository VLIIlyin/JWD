package com.epam.jwd.figures.model.multiangle;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.exception.FigurePointsException;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigurePointCheckPreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiAngleFactory {

    public static final int MIN_RANDOM_VALUE = 4;
    public static final int MAX_RANDOM_VALUE = 6;
    static final Logger LOGGER = LogManager.getLogger(MultiAngleFactory.class);

    public static void createAndPrintFigure(int countOfFigures, int countOfPoints) throws FigureNotExistException {
        MultiAngleFigure[] figures = createFigure(countOfFigures, countOfPoints);
        printInfoAboutFigures(figures);
    }

    private static MultiAngleFigure[] createFigure(int countOfFigures, int countOfPoints) {
        MultiAngleFigure[] multiAngleFigures = new MultiAngleFigure[countOfFigures];

        for (int i = 0; i < countOfFigures; i++) {
            Point[] pointsForMultiAngleFigure = PointFactory.generateRandomArrayForFigure(countOfPoints);
            try {
                if (FigurePointCheckPreProcessor.process(pointsForMultiAngleFigure)) {
                    multiAngleFigures[i] = new MultiAngleFigure(countOfPoints, pointsForMultiAngleFigure);
                    LOGGER.info(String.format("Figure object created with number of points = %d", countOfPoints));
                }
            } catch (FigurePointsException e) {
                e.printStackTrace();
            }
        }

        return multiAngleFigures;
    }

    private static void printInfoAboutFigures(MultiAngleFigure[] multiAngleFigures){
        for (MultiAngleFigure multiAngleFigure : multiAngleFigures) {
            printInfoAboutFigure(multiAngleFigure);
        }
    }

    private static void printInfoAboutFigure(MultiAngleFigure multiAngleFigure){
        try {
            if (FigureExistencePostProcessor.process(multiAngleFigure)) {
                LOGGER.info(multiAngleFigure);
            } else {
                LOGGER.error("Figure cannot exist");
            }
        } catch (FigureNotExistException e) {
            e.printStackTrace();
        }
    }
}

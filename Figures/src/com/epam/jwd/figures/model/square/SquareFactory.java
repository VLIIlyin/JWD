package com.epam.jwd.figures.model.square;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.exception.FigurePointsException;
import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import com.epam.jwd.service.impl.FigurePointCheckPreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class SquareFactory {

    static final Logger LOGGER = LogManager.getLogger(SquareFactory.class);
    static boolean objectSquareCreated;

    public static void createAndPrintSquare(){
        Square[] squares = createSquareArrayFromPoints();

        if (objectSquareCreated) {
            printInfoAboutSquares(squares);
        } else {
            LOGGER.error("Square object was no created");
        }
    }

    private static Square[] createSquareArrayFromPoints() {
        return new Square[]{createSquareFromFourFirstPoints(PointFactory.generateRandomArray()),
                createSquareFromFourFirstPoints(PointFactory.generateRandomArray())};
    }

    private static Square createSquareFromFourFirstPoints(Point[] points) {
        if (points.length >= 4) {
            try {
                if (FigurePointCheckPreProcessor.process(points)) {
                    objectSquareCreated = true;
                    LOGGER.info("Square object created from four points of array");
                    return Square.getInstance(points[0], points[1], points[2], points[3]);
                } else {
                    LOGGER.error("Square object cannot be created because some of points are the same");
                    return null;
                }
            } catch (FigurePointsException e) {
                LOGGER.error(e.getMessage());
            }
        } else {
            LOGGER.error("Square object cannot be created because number of points less than 4");
            return null;
        }
        return null;
    }

    private static void printInfoAboutSquares(Square[] squares) {
        for (Square square : squares) {
            printInfoAboutSquare(square);
        }
    }

    private static void printInfoAboutSquare(Square square) {
        try {
            if (FigureExistencePostProcessor.process(square)) {
                LOGGER.info(square);
                printCalculatedPerimeter(square);
                printCalculatedArea(square);
            } else {
                LOGGER.error(String.format(Locale.US, "Square with next points: %s %s %s %s cannot exist",
                        square.getFirstPoint(),
                        square.getSecondPoint(),
                        square.getThirdPoint(),
                        square.getFourthPoint()));
            }
        } catch (FigureNotExistException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private static void printCalculatedPerimeter(Square square) {
        LOGGER.info(String.format("Perimeter = %s ",
                Figure.getFigureStrategyInterface(square).calculatePerimeter(new Point[]{
                        square.getFirstPoint(),
                        square.getSecondPoint(),
                        square.getThirdPoint(),
                        square.getFourthPoint()})));
    }

    private static void printCalculatedArea(Square square) {
        LOGGER.info(String.format("Area = %s",
                Figure.getFigureStrategyInterface(square).calculateArea(new Point[]{
                        square.getFirstPoint(),
                        square.getSecondPoint(),
                        square.getThirdPoint(),
                        square.getFourthPoint()})));
    }
}

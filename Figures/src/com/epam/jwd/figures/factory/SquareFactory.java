package com.epam.jwd.figures.factory;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.Point;
import com.epam.jwd.figures.model.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class SquareFactory {

    final static Logger Logger = LogManager.getLogger(SquareFactory.class);
    static boolean objectSquareCreated;

    public static void createAndPrintSquare() {
        Square[] squares = createSquareArrayFromPoints();

        if (objectSquareCreated) {
            printInfoAboutSquares(squares);
        } else {
            Logger.error("Square object was no created");
        }
    }

    private static Square[] createSquareArrayFromPoints() {
        return new Square[]{createSquareFromFourFirstPoints(PointFactory.generateRandomArray())};
    }

    private static Square createSquareFromFourFirstPoints(Point[] points) {
        if (points.length >= 4) {

            objectSquareCreated = true;
            Logger.info("Square object created from four points of array");

            return new Square(points[0], points[1], points[2], points[3]);
        } else {
            Logger.error("Square object cannot be created because number of points less than 4");

            return null;
        }
    }

    private static void printInfoAboutSquares(Square[] squares) {
        for (Square square : squares) {
            printInfoAboutSquare(square);
        }
    }

    private static void printInfoAboutSquare(Square square) {
        if (square.isPointsAreDifferent()) {
            if (square.isSumOfSideCorrect()) {
                Logger.info(square);
                printCalculatedPerimeter(square);
                printCalculatedArea(square);
            } else {
                Logger.error(String.format(Locale.US, "Square with next points: %s %s %s %s cannot exist",
                        square.getFirstPoint(),
                        square.getSecondPoint(),
                        square.getThirdPoint(),
                        square.getFourthPoint()));
            }
        } else {
            Logger.error(String.format(Locale.US, "Object %s is not square", square));
        }
    }

    private static void printCalculatedPerimeter(Square square) {
        Logger.info(String.format("Perimeter = %s ",
                Figure.getFigureStrategyInterface(square).calculatePerimeter(new Point[]{
                        square.getFirstPoint(),
                        square.getSecondPoint(),
                        square.getThirdPoint(),
                        square.getFourthPoint()})));
    }

    private static void printCalculatedArea(Square square) {
        Logger.info(String.format("Area = %s",
                Figure.getFigureStrategyInterface(square).calculateArea(new Point[]{
                        square.getFirstPoint(),
                        square.getSecondPoint(),
                        square.getThirdPoint(),
                        square.getFourthPoint()})));
    }
}

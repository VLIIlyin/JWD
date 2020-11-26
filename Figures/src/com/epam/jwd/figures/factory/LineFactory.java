package com.epam.jwd.figures.model.factory;

import com.epam.jwd.figures.model.Line;
import com.epam.jwd.figures.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineFactory {

    final static Logger Logger = LogManager.getLogger(LineFactory.class);
    static boolean objectLineCreated;

    public static void createAndPrintLineArray(){
        Line[] lines = creteLineArrayFromPoints();

        if (objectLineCreated) {
            printInfoAboutLines(lines);
        }
        else{
            Logger.error("Line object was no created");
        }
    }

    private static Line[] creteLineArrayFromPoints(){
        return new Line[]{createLineFromTwoFirstPoints(PointFactory.generateRandomArray()),
                createLineFromTwoFirstPoints(PointFactory.generateRandomArray())};
    }

    private static Line createLineFromTwoFirstPoints(Point[] points){
        if (points.length >= 2) {
            Point[] pointForLine = new Point[2];
            int counter = 2;

            System.arraycopy(points, 0, pointForLine, 0, counter);

            objectLineCreated = true;
            Logger.info("Line created from first two points of array");

            return new Line(pointForLine[0], pointForLine[1]);
        }
        else {
            Logger.error("Line object cannot be created because number of points less than 2");

            return null;
        }
    }

    private static void printInfoAboutLines(Line[] lines){
        for (Line line : lines) {
            printInfoAboutLine(line);
        }
    }

    private static void printInfoAboutLine(Line line){
        if (line.isFigureCanExist()) {
            Logger.info(line);
        }
        else {
            Logger.error(String.format("Line with next points: %f %f cannot exist",
                    line.getFirstPoint(),
                    line.getSecondPoint()));
        }
    }

}

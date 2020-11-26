package com.epam.jwd.figures.model.line;

import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.model.point.PointFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineFactory {

    static final Logger LOGGER = LogManager.getLogger(LineFactory.class);
    static boolean objectLineCreated;

    public static void createAndPrintLineArray(){
        Line[] lines = createLineArrayFromPoints();

        if (objectLineCreated) {
            printInfoAboutLines(lines);
        }
        else{
            LOGGER.error("Line object was no created");
        }
    }

    private static Line[] createLineArrayFromPoints(){
        return new Line[]{createLineFromTwoFirstPoints(PointFactory.generateRandomArray()),
                createLineFromTwoFirstPoints(PointFactory.generateRandomArray())};
    }

    private static Line createLineFromTwoFirstPoints(Point[] points){
        if (points.length >= 2) {
            Point[] pointForLine = new Point[2];
            int counter = 2;

            System.arraycopy(points, 0, pointForLine, 0, counter);

            objectLineCreated = true;
            LOGGER.info("Line created from first two points of array");

            return new Line(pointForLine[0], pointForLine[1]);
        }
        else {
            LOGGER.error("Line object cannot be created because number of points less than 2");

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
            LOGGER.info(line);
        }
        else {
            LOGGER.error(String.format("Line with next points: %s %s cannot exist",
                    line.getFirstPoint(),
                    line.getSecondPoint()));
        }
    }

}

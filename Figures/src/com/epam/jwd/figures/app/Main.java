package com.epam.jwd.figures.app;

import com.epam.jwd.figures.model.line.LineFactory;
import com.epam.jwd.figures.model.multiangle.MultiAngleFactory;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.figures.model.square.SquareFactory;
import com.epam.jwd.figures.model.triangle.TriangleFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    final static Logger Logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Logger.info("Application started");

        /*PointFactory.createAndPrintPointArray();
        LineFactory.createAndPrintLineArray();
        TriangleFactory.createAndPrintTriangle();*/
        SquareFactory.createAndPrintSquare();
        //MultiAngleFactory.createAndPrintFigure();

        Logger.info("Application ended");
    }

}

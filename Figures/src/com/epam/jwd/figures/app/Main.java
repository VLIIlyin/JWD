package com.epam.jwd.figures.app;

import com.epam.jwd.figures.factory.LineFactory;
import com.epam.jwd.figures.factory.PointFactory;
import com.epam.jwd.figures.factory.SquareFactory;
import com.epam.jwd.figures.factory.TriangleFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    final static Logger Logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Logger.info("Application started");

        PointFactory.createAndPrintPointArray();
        LineFactory.createAndPrintLineArray();
        TriangleFactory.createAndPrintTriangle();
        SquareFactory.createAndPrintSquare();

        Logger.info("Application ended");
    }

}

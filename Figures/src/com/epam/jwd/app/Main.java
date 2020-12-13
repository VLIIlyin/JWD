package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.figures.model.multiangle.MultiAngleFigure;
import com.epam.jwd.figures.model.square.Square;
import com.epam.jwd.figures.model.triangle.Triangle;
import com.epam.jwd.service.api.FigureService;
import com.epam.jwd.service.impl.UniversalFigureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {

    final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws FigureException {

        LOGGER.info("Application started");

        FigureService<MultiAngleFigure> multiAngleFigureService = new UniversalFigureService(
                MultiAngleFigure.class,
                new ArrayList());
        multiAngleFigureService.multiCreate(5);
        multiAngleFigureService.update(1);
        multiAngleFigureService.save(multiAngleFigureService.create());
        multiAngleFigureService.delete(5);

        FigureService<Triangle> triangleFigureService = new UniversalFigureService(
                Triangle.class,
                new ArrayList());
        triangleFigureService.multiCreate(5);
        triangleFigureService.update(1);
        triangleFigureService.save(triangleFigureService.create());
        triangleFigureService.delete(5);

        FigureService<Square> squareFigureService = new UniversalFigureService(
                Square.class,
                new ArrayList());
        squareFigureService.multiCreate(5);
        squareFigureService.update(1);
        squareFigureService.save(squareFigureService.create());
        squareFigureService.delete(5);

        LOGGER.info("Application ended");
    }
}

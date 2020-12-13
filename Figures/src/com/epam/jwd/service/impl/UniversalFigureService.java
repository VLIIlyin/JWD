package com.epam.jwd.service.impl;

import com.epam.jwd.app.MultiAngleAppContext;
import com.epam.jwd.app.SquareAppContext;
import com.epam.jwd.app.TriangleAppContext;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.multiangle.MultiAngleFigure;
import com.epam.jwd.figures.model.multiangle.MultiAngleFigureFactory;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.figures.model.square.Square;
import com.epam.jwd.figures.model.square.SquareFigureFactory;
import com.epam.jwd.figures.model.triangle.Triangle;
import com.epam.jwd.figures.model.triangle.TriangleFigureFactory;
import com.epam.jwd.service.api.AppContext;
import com.epam.jwd.service.api.FigureFactory;
import com.epam.jwd.service.api.FigureService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class UniversalFigureService<T extends Figure> implements FigureService<T> {

    final static Logger LOGGER = LogManager.getLogger(UniversalFigureService.class);

    private T figure;
    AppContext appContext;
    FigureFactory figureFactory;
    private final Class<T> type;
    private final List<T> figures;
    private int countOfFigures;

    public UniversalFigureService(Class<T> type, List<T> figures) {
        this.type = type;
        this.figures = figures;
        for (T figure : figures) {
            if (figure != null) {
                countOfFigures++;
            }
        }
    }

    public Class<T> getType() {
        return type;
    }

    public int getCountOfFigures() {
        return countOfFigures;
    }

    @Override
    public T create() throws FigureException {
        if (type == MultiAngleFigure.class) {
            appContext = new MultiAngleAppContext();
            figureFactory = appContext.createFigureFactory();
            figure = (T) figureFactory.create(
                    PointFactory.generateRandomArrayForFigure(MultiAngleFigureFactory.COUNT_OF_POINTS));
        }
        if (type == Triangle.class) {
            appContext = new TriangleAppContext();
            figureFactory = appContext.createFigureFactory();
            figure = (T) figureFactory.create(
                    PointFactory.generateRandomArrayForFigure(TriangleFigureFactory.COUNT_OF_POINTS));
        }
        if (type == Square.class) {
            appContext = new SquareAppContext();
            figureFactory = appContext.createFigureFactory();
            figure = (T) figureFactory.create(
                    PointFactory.generateRandomArrayForFigure(SquareFigureFactory.COUNT_OF_POINTS));
        }

        LOGGER.info("Figure created");
        return figure;
    }

    @Override
    public void multiCreate(int numberOfFigures) throws FigureException {
        for (int i = 0; i < numberOfFigures; i++) {
            save(create());
        }

        LOGGER.info("Multi creation completed");
    }

    @Override
    public void delete(int num) {
        try {
            figures.remove(num);
            LOGGER.info("Figure removed");
        }catch (IndexOutOfBoundsException e){
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        figures.clear();
        LOGGER.info("ALL figures removed");
    }

    @Override
    public void update(int num) throws FigureException {
        figure = findById(num);
        if (figure != null) {
            figures.set(num, create());
            LOGGER.info("Figure updated");
        }
        else{
            LOGGER.error("Index wrong");
        }
    }

    @Override
    public void save(T figure) {
        if (figure != null) {
            figures.add(figure);
            countOfFigures++;
            LOGGER.info("Figure saved");
        }
    }

    @Override
    public List<T> findAll() {
        return figures;
    }

    @Override
    public T findById(int num) {
        try{
            figure = figures.get(num);
        }catch (IndexOutOfBoundsException e){
            LOGGER.error(e.getMessage());
        }
        return figure;
    }
}

package com.epam.jwd.service.impl;

import com.epam.jwd.app.MultiAngleAppContext;
import com.epam.jwd.app.SquareAppContext;
import com.epam.jwd.app.TriangleAppContext;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.multiangle.MultiAngleFigure;
import com.epam.jwd.figures.model.multiangle.MultiAngleFigureFactory;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.model.point.PointFactory;
import com.epam.jwd.figures.model.square.Square;
import com.epam.jwd.figures.model.square.SquareFigureFactory;
import com.epam.jwd.figures.model.triangle.Triangle;
import com.epam.jwd.figures.model.triangle.TriangleFigureFactory;
import com.epam.jwd.service.api.AppContext;
import com.epam.jwd.service.api.FigureFactory;
import com.epam.jwd.service.api.FigureService;
import com.epam.jwd.service.api.SearchCriteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

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

    public T create() {
        try {
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
                figure = (T) figureFactory.create(new Point[]{
                                new Point(1, 1),
                                new Point(1, 2),
                                new Point(2, 2),
                                new Point(2, 1),
                        });
                       // PointFactory.generateRandomArrayForFigure(SquareFigureFactory.COUNT_OF_POINTS));
            }

            LOGGER.info("Figure created");
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        return figure;
    }

    @Override
    public void multiCreate(int numberOfFigures) throws FigureException {
        for (int i = 0; i < numberOfFigures; i++) {
            save(create());
        }

        LOGGER.info("Multi creation completed");
    }

    public void delete(int num) {
        try {
            figures.remove(num);
            LOGGER.info("Figure removed");
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteAll() {
        figures.clear();
        LOGGER.info("ALL figures removed");
    }

    public void update(int num) throws FigureException {
        figure = findById(num);
        if (figure != null) {
            figures.set(num, create());
            LOGGER.info("Figure updated");
        } else {
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
        try {
            figure = figures.get(num);
        } catch (IndexOutOfBoundsException e) {
            LOGGER.error(e.getMessage());
        }
        return figure;
    }

    public List<T> getFigures() {
        return figures;
    }

    public List<T> multiCriteriaSearch(SearchCriteria searchCriteria, List<T> filteredFigures) {

        if (searchCriteria.getFigureList() != null) {
            filteredFigures.addAll(searchCriteria.getFigureList());
        }

        if (searchCriteria.getArea() != 0) {
            filteredFigures = figures.stream()
                    .filter(f -> f.calculateArea() > searchCriteria.getArea())
                    .collect(Collectors.toList());
        }

        if (searchCriteria.getPerimeter() != 0) {
            filteredFigures = figures.stream()
                    .filter(f -> f.calculatePerimeter() < searchCriteria.getPerimeter())
                    .collect(Collectors.toList());
        }

        if (searchCriteria.getPerimeterPlusArea() != 0) {
            filteredFigures = figures.stream()
                    .filter(f -> f.calculatePerimeter() + f.calculateArea()
                            > searchCriteria.getPerimeterPlusArea())
                    .collect(Collectors.toList());
        }

        if (searchCriteria.getPerimeterMultiplyArea() != 0) {
            filteredFigures = figures.stream()
                    .filter(f -> f.calculatePerimeter() * f.calculateArea()
                            < searchCriteria.getPerimeterMultiplyArea())
                    .collect(Collectors.toList());
        }

        return filteredFigures;
    }
}

package com.epam.jwd.figures.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.service.api.FigureFactory;
import com.epam.jwd.service.api.FigurePostProcessor;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostProcessDecorator implements FigureFactory {

    static final Logger LOGGER = LogManager.getLogger(PostProcessDecorator.class);
    private final FigurePostProcessor figurePostProcessor = new FigureExistencePostProcessor();
    private final FigureFactory figureFactory;

    public PostProcessDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure create(Point[] points) throws FigureNotExistException {
        try {
            Figure figure = figureFactory.create(points);
            figure = figurePostProcessor.postProcess(figure);
            LOGGER.info("Figure created");
            LOGGER.info(figure);
            return figure;
        } catch (FigureNotExistException e) {
            LOGGER.error(e.getMessage());
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        return null;
    }
}

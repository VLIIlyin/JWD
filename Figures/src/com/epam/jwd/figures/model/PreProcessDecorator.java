package com.epam.jwd.figures.model;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigurePointsException;
import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.service.api.FigureFactory;
import com.epam.jwd.service.api.FigurePreProcessor;
import com.epam.jwd.service.impl.FigurePointCheckPreProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PreProcessDecorator implements FigureFactory {

    static final Logger LOGGER = LogManager.getLogger(PreProcessDecorator.class);
    private final FigurePreProcessor figurePreProcessor= new FigurePointCheckPreProcessor();
    private final FigureFactory figureFactory;

    public PreProcessDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure create(Point[] points) throws FigurePointsException {
        try {
            if(figurePreProcessor.preProcess(points)){
                return figureFactory.create(points);
            }
        } catch (FigurePointsException e){
            LOGGER.error(e.getMessage());
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        return null;
    }
}

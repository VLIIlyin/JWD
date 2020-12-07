package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.service.api.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    public static boolean process(Figure figure) throws FigureNotExistException {
        if (!isFigureExists(figure)){
            throw new FigureNotExistException("Figure cannot be exist");
        }

        return true;
    }

    public static boolean isFigureExists(Figure figure){
        return figure.isFigureCanExist();
    }
}

package com.epam.jwd.service.api;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.figures.model.Figure;

public interface FigurePostProcessor {
    static boolean process(Figure figure) throws FigureNotExistException {
        return false;
    }
}

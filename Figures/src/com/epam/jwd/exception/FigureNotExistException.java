package com.epam.jwd.exception;

import com.epam.jwd.figures.model.point.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureNotExistException extends FigureException {

    static final Logger LOGGER = LogManager.getLogger(FigureNotExistException.class);

    public FigureNotExistException(String message, Point point) {
        super(message, point);
    }

    public void logException(String message) {
        LOGGER.error(message);
    }
}

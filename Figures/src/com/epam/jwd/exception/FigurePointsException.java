package com.epam.jwd.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigurePointsException extends FigureException {

    static final Logger LOGGER = LogManager.getLogger(FigurePointsException.class);

    public FigurePointsException(String message) {
        super(message);
    }
}
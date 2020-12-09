package com.epam.jwd.service.api;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.exception.FigurePointsException;
import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.figures.model.point.Point;

public interface FigureFactory {
    Figure create(Point[] points) throws FigureException;
}

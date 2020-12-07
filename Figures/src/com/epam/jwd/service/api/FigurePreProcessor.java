package com.epam.jwd.service.api;

import com.epam.jwd.figures.model.point.Point;

public interface FigurePreProcessor {
    static boolean process(Point[] points) {
        return false;
    }
}
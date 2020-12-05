package com.epam.jwd.service.impl;

import com.epam.jwd.figures.model.point.Point;
import com.epam.jwd.figures.service.PointService;
import com.epam.jwd.service.FigurePreProcessor;

public class FigurePointCheckPreProcessor implements FigurePreProcessor {

    public static boolean process(Point[] points){
        return PointService.isPointsAreDifferent(points);
    }
}

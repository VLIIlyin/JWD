package com.epam.jwd.figures.service;

import com.epam.jwd.figures.model.point.Point;

public class PointService {
    private static double intervalCoordX(Point pointFirst, Point pointSecond){
        return pointFirst.getCoordX() - pointSecond.getCoordX();
    }

    private static double intervalCoordY(Point pointFirst, Point pointSecond){
        return pointFirst.getCoordY() - pointSecond.getCoordY();
    }

    public static double intervalBetweenPoints(Point pointFirst, Point pointSecond){
        return Math.sqrt(Math.pow(intervalCoordX(pointFirst, pointSecond), 2)
                + Math.pow(intervalCoordY(pointFirst, pointSecond), 2));
    }
}

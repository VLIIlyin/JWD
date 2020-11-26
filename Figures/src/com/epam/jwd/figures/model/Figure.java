package com.epam.jwd.figures.model;

import com.epam.jwd.figures.strategy.FigureStrategyInterface;

public abstract class Figure implements FigureInterface{

    public static FigureStrategyInterface figureStrategyInterface = null;

    public static FigureStrategyInterface getFigureStrategyInterface(Figure figure) {
        return figure.figureStrategyInterface;
    }

    public static void setFigureStrategyInterface(FigureStrategyInterface figureStrategyInterface) {
        Figure.figureStrategyInterface = figureStrategyInterface;
    }

    public abstract String toString();
}

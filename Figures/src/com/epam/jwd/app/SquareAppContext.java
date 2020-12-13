package com.epam.jwd.app;

import com.epam.jwd.figures.model.PostProcessDecorator;
import com.epam.jwd.figures.model.PreProcessDecorator;
import com.epam.jwd.figures.model.square.SquareFigureFactory;
import com.epam.jwd.service.api.AppContext;
import com.epam.jwd.service.api.FigureFactory;

public class SquareAppContext implements AppContext {
    @Override
    public FigureFactory createFigureFactory() {
        return new PostProcessDecorator(new PreProcessDecorator(new SquareFigureFactory()));
    }
}
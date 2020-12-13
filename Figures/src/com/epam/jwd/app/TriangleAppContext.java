package com.epam.jwd.app;

import com.epam.jwd.figures.model.PostProcessDecorator;
import com.epam.jwd.figures.model.PreProcessDecorator;
import com.epam.jwd.figures.model.triangle.TriangleFigureFactory;
import com.epam.jwd.service.api.AppContext;
import com.epam.jwd.service.api.FigureFactory;

public class TriangleAppContext implements AppContext {
    @Override
    public FigureFactory createFigureFactory() {
        return new PostProcessDecorator(new PreProcessDecorator(new TriangleFigureFactory()));
    }
}
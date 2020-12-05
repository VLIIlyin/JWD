package com.epam.jwd.service.impl;

import com.epam.jwd.figures.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;

public class FigureExistencePostProcessor implements FigurePostProcessor {

    public static boolean process(Figure figure) {
        return figure.isFigureCanExist();
    }
}

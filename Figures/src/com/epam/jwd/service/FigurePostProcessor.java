package com.epam.jwd.service;

import com.epam.jwd.figures.model.Figure;

public interface FigurePostProcessor {
    static boolean process(Figure figure) {
        return false;
    }
}

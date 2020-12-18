package com.epam.jwd.service.api;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.figures.model.Figure;

import java.util.List;

public interface FigureService<T extends Figure> {

    T create();
    void multiCreate(int NumberOfFigures) throws FigureException;
    void delete(int num);
    void deleteAll();
    void update(int num) throws FigureException;
    void save(T figure);
    List<T> findAll();
    T findById(int num);
    List<T> multiCriteriaSearch(SearchCriteria searchCriteria, List<T> ff);
}

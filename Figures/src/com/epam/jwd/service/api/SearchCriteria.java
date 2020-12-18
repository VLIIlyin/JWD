package com.epam.jwd.service.api;

import java.util.List;

public interface SearchCriteria<T> {

    public double getArea();

    public double getPerimeter();

    public double getPerimeterPlusArea();

    public double getPerimeterMultiplyArea();

    public List<T> getFigureList();
}

package com.epam.jwd.service.impl;

import com.epam.jwd.service.api.SearchCriteria;

import java.util.List;

public class UniversalSearchCriteria<T> implements SearchCriteria {

    private final double area;
    private final double perimeter;
    private final double perimeterPlusArea;
    private final double perimeterMultiplyArea;
    private final List<T> figureList;

    public UniversalSearchCriteria(double area, double perimeter, double perimeterPlusArea,
                                   double perimeterMultiplyArea, List<T> figureList) {
        this.area = area;
        this.perimeter = perimeter;
        this.perimeterPlusArea = perimeterPlusArea;
        this.perimeterMultiplyArea = perimeterMultiplyArea;
        this.figureList = figureList;
    }

    public double getArea() {
        return area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getPerimeterPlusArea() {
        return perimeterPlusArea;
    }

    public double getPerimeterMultiplyArea() {
        return perimeterMultiplyArea;
    }

    public List<T> getFigureList() {
        return figureList;
    }


    @Override
    public String toString() {
        return "UniversalSearchCriteria{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", perimeterPlusArea=" + perimeterPlusArea +
                ", perimeterMultiplyArea=" + perimeterMultiplyArea +
                ", figureList=" + figureList +
                '}';
    }

    public static CriteriaBuilder builder(){
        return new CriteriaBuilder();
    }

    public static class CriteriaBuilder<T> {
        private  double area;
        private  double perimeter;
        private  double perimeterPlusArea;
        private  double perimeterMultiplyArea;
        private  List<T> figureList;

        public CriteriaBuilder areaMoreThan(double area){
            this.area = area;
            return this;
        }

        public CriteriaBuilder perimeterLessThan(double perimeter){
            this.perimeter = perimeter;
            return this;
        }

        public CriteriaBuilder perimeterPlusAreaMoreThan(double perimeterPlusArea){
            this.perimeterPlusArea = perimeterPlusArea;
            return this;
        }

        public CriteriaBuilder perimeterMultiplyAreaLessThan(double perimeterMultiplyArea){
            this.perimeterMultiplyArea = perimeterMultiplyArea;
            return this;
        }

        public UniversalSearchCriteria build(){
            return new UniversalSearchCriteria(this.area,
                    this.perimeter,
                    this.perimeterPlusArea,
                    this.perimeterMultiplyArea,
                    this.figureList);
        }
    }
}

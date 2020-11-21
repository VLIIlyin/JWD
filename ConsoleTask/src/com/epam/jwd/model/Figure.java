package com.epam.jwd.model;

public class Figure {
    public float length;
    public float height;
    public float width;
    public String name;

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public String getName() {
        return name;
    }

    public Figure(float length, float height, float width, String name){
        this.length = length;
        this.height = height;
        this.width = width;
        this.name = name;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Figure name is " + name + " with next parameters: length "
                + length + " height " + height + " width " + width;
    }
}

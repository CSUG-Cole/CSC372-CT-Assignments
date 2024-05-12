package com.csc372.module_4;

public class Cylinder extends Shape
{
    private double radius;
    private double height;

    /* Constructor */
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    /* Override base class methods */
    /* Formula 2πr(r+h) */
    @Override
    public double surfaceArea() { return 2 * Math.PI * radius * (radius + height); }

    /* Formula is πhr² */
    @Override
    public double volume() { return Math.PI * height * radius * radius; }

    @Override
    public String toString() {
        return "Cylinder: SurfaceArea = " + surfaceArea() + ", Volume = " + volume();
    }
}

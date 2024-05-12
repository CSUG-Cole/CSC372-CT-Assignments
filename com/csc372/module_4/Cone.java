package com.csc372.module_4;

public class Cone extends Shape
{
    private double radius;
    private double height;

    /* Constructor */
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    /* Override base class methods */
    /* Formula πr(r+(√(r²+h²))) */
    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    /* Formula is πr²h/3 */
    @Override
    public double volume() { return Math.PI * radius * radius * height / 3; }

    @Override
    public String toString() {
        return "Cone: SurfaceArea = " + surfaceArea() + ", Volume = " + volume();
    }
}

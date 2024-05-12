package com.csc372.module_4;

public class Sphere extends Shape
{
    private double radius;

    /* Constructor */
    public Sphere(double radius) { this.radius = radius; }

    /* Override base class methods */
    /* Formula 4πr²^2 */
    @Override
    public double surfaceArea() { return 4 * Math.PI * radius * radius; }

    /* Formula is 4/3πr³ */
    @Override
    public double volume() { return (4.0 / 3) * Math.PI * radius * radius * radius; }

    @Override
    public String toString() {
        return "Sphere: SurfaceArea = " + surfaceArea() + ", Volume = " + volume();
    }
}

package org.example;

public class TriangleAreaCalculator {
    public static double calculateArea(double a, double b, double c) {
        if (a + b > c && a + c > b && b + c > a) {
            double semiPerimeter = (a + b + c) / 2;
            return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
        } else {
            return -1; // Не образует треугольник
        }
    }
}

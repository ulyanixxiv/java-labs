package org.example;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }


@Override
public String toString() {
        return "Okrugnost { radius = " + radius + "}";
}


    public void displayInfo() {
        System.out.printf("Окружность: радиус = %.2f | Площадь = %.2f | Длина окружности = %.2f%n",
                radius, area(), circumference());
    }
}
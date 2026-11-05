package org.example;

public class Undergraduate extends Student {
    private int year; // курс обучения (1-4)

    public Undergraduate(String name, int id, double grade, int year) {
        super(name, id, grade);
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(" | Бакалавриат (курс: %d)%n", year);
    }

    @Override
    public String toString() {
        return String.format("Бакалавр [ID: %d, Имя: %s, Ср. балл: %.2f, Курс: %d]",
                getId(), getName(), getGrade(), year);
    }
}

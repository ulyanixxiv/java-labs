package org.example;

public class PhD extends Student {
    private int publications; // количество научных публикаций

    public PhD(String name, int id, double grade, int publications) {
        super(name, id, grade);
        this.publications = publications;
    }

    public int getPublications() {
        return publications;
    }

    public void setPublications(int publications) {
        this.publications = publications;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(" | Аспирантура (публикаций: %d)%n", publications);
    }

    @Override
    public String toString() {
        return String.format("Аспирант [ID: %d, Имя: %s, Ср. балл: %.2f, Публикаций: %d]",
                getId(), getName(), getGrade(), publications);
    }
}

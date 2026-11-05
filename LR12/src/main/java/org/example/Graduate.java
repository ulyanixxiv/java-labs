package org.example;

public class Graduate extends Student {
    private String thesis; // тема магистерской диссертации

    public Graduate(String name, int id, double grade, String thesis) {
        super(name, id, grade);
        this.thesis = thesis;
    }

    public String getThesis() {
        return thesis;
    }

    public void setThesis(String thesis) {
        this.thesis = thesis;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(" | Магистратура (тема ВКР: «%s»)%n", thesis);
    }

    @Override
    public String toString() {
        return String.format("Магистр [ID: %d, Имя: %s, Ср. балл: %.2f, ВКР: «%s»]",
                getId(), getName(), getGrade(), thesis);
    }
}

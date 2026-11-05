package org.example;

public class FamilyMember {
    private String name;
    private String role;
    private int age;
    private String occupation;

    public FamilyMember(String name, String role, int age, String occupation) {
        this.name = name;
        this.role = role;
        this.age = age;
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("%-12s | %-16s | Возраст: %2d | Профессия: %s",
                role, name, age, occupation);
    }
}

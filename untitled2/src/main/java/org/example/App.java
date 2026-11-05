package org.example;

public abstract class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void activity();

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
package org.example;

public class Student extends Human {
    private String university;

    public Student(String name, int age, String university) {
        super(name, age);
        this.university = university;
    }

    @Override
    public void activity() {
        System.out.println("Учится в университете");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Университет: " + university);
    }
}
package org.example;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Иван", 20, "БГУ");
        Student student1 = new Student("Анна", 19, "БНТУ");
        student.displayInfo();
        student1.displayInfo();
        student.activity();
    }
}
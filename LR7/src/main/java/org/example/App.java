package org.example;

public class App {
    public static void main(String[] args) {
        Smartphone phone1 = new Smartphone("Apple iPhone 15 Pro", 256, 48);
        Smartphone phone2 = new Smartphone("Samsung Galaxy S24", 128, 50);
        Smartphone phone3 = new Smartphone("Xiaomi 14 Ultra", 512, 50);
        Smartphone phone4 = new Smartphone("Google Pixel 8 Pro", 128, 50);
        Smartphone phone5 = new Smartphone("OnePlus 12", 256, 64);

        System.out.println();
        System.out.println("Список созданных смартфонов:");
        phone1.displayInfo();
        phone2.displayInfo();
        phone3.displayInfo();
        phone4.displayInfo();
        phone5.displayInfo();

        System.out.println();
        System.out.println("Статистика по всем смартфонам:");
        System.out.println("Всего смартфонов: " + Smartphone.getTotalPhones() + " шт.");
        System.out.println("Суммарная память: " + Smartphone.getTotalMemory() + " ГБ");
        System.out.printf("Средний объем памяти: %.2f ГБ%n", Smartphone.getAverageMemory());
    }
}

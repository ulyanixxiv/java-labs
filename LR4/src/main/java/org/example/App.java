package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("ЗАДАНИЕ 1");
        Circle c1 = new Circle(3.5);
        Circle c2 = new Circle(7.0);
        Circle c3 = new Circle(12.2);

        c1.displayInfo();
        c2.displayInfo();
        c3.displayInfo();
        System.out.println(c1);


        System.out.println("\nЗАДАНИЕ 2");
        Game[] games = {
                new Game("The Witcher 3", "RPG", 11.00),
                new Game("Cyberpunk 2077", "Action RPG", 19.00),
                new Game("Hollow Knight", "Metroidvania", 14.00),
                new Game("Terraria", "Sandbox", 24.00),
                new Game("Baldur's Gate 3", "RPG", 29.00)
        };

        Game mostExpensive = games[0];
        Game cheapest = games[0];

        for (Game g : games) {
            if (g.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = g;
            }
            if (g.getPrice() < cheapest.getPrice()) {
                cheapest = g;
            }
        }

        System.out.printf("Самая дорогая игра: «%s» (%.2f руб.)%n",
                mostExpensive.getTitle(), mostExpensive.getPrice());
        System.out.printf("Самая дешевая игра: «%s» (%.2f руб.)%n",
                cheapest.getTitle(), cheapest.getPrice());



        System.out.println("\nЗАДАНИЕ 3");
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.isWeekend()) {
                System.out.printf("%-10s — Выходной день%n", day);
            } else {
                System.out.printf("%-10s — Рабочий день%n", day);
            }
        }
    }
}
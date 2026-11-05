import java.util.Scanner;

// Задание 1 (Вариант 7): Класс «Окружность» (Circle)
class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public void displayInfo(int index) {
        System.out.printf("Окружность #%d: радиус R = %.2f | Площадь S = %.2f | Длина окружности C = %.2f%n",
                index, radius, area(), circumference());
    }
}

// Задание 2 (Вариант 7): Класс «Игра» (Game)
class Game {
    private String title;
    private String genre;
    private double price;

    public Game(String title, String genre, double price) {
        this.title = title;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("«%s» (Жанр: %s, Цена: %.2f руб.)", title, genre, price);
    }
}

// Задание 3 (Вариант 7): Перечисление DayOfWeek с методом isWeekend()
enum DayOfWeek {
    MONDAY("Понедельник"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота"),
    SUNDAY("Воскресенье");

    private final String russianName;

    DayOfWeek(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

public class LR5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================================================");
            System.out.println("   ЛАБОРАТОРНАЯ РАБОТА № 5: Классы, объекты и Enum (Вариант 7)");
            System.out.println("==================================================================");
            System.out.println("1. Задание 1 (Вариант 7): Класс «Окружность» (Circle) — area() и circumference()");
            System.out.println("2. Задание 2 (Вариант 7): Массив из 5 объектов класса «Игра» (Game) — поиск самой дорогой и дешевой");
            System.out.println("3. Задание 3 (Вариант 7): Enum DayOfWeek с методом isWeekend()");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    executeTask1();
                    break;
                case 2:
                    executeTask2();
                    break;
                case 3:
                    executeTask3();
                    break;
                case 0:
                    System.out.println("Выход из программы Лабораторной работы № 5.");
                    break;
                default:
                    System.out.println("Неверный пункт меню!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void executeTask1() {
        System.out.println("\n--- Задание 1 (Вариант 7): Несколько окружностей и их параметры ---");
        Circle[] circles = {
            new Circle(3.0),
            new Circle(5.5),
            new Circle(10.0)
        };
        for (int i = 0; i < circles.length; i++) {
            circles[i].displayInfo(i + 1);
        }
    }

    private static void executeTask2() {
        System.out.println("\n--- Задание 2 (Вариант 7): Массив из 5 игр (поиск самой дорогой и самой дешевой) ---");
        Game[] games = {
            new Game("The Witcher 3", "RPG", 89.90),
            new Game("Cyberpunk 2077", "Action-RPG", 149.50),
            new Game("Terraria", "Sandbox", 24.00),
            new Game("Baldur's Gate 3", "RPG", 179.99),
            new Game("Hollow Knight", "Metroidvania", 38.50)
        };

        System.out.println("Список всех игр:");
        for (int i = 0; i < games.length; i++) {
            System.out.println("  " + (i + 1) + ". " + games[i]);
        }

        Game mostExpensive = games[0];
        Game cheapest = games[0];

        for (int i = 1; i < games.length; i++) {
            if (games[i].getPrice() > mostExpensive.getPrice()) {
                mostExpensive = games[i];
            }
            if (games[i].getPrice() < cheapest.getPrice()) {
                cheapest = games[i];
            }
        }

        System.out.println("\nРезультаты поиска:");
        System.out.println("  Самая дорогая игра : " + mostExpensive);
        System.out.println("  Самая дешевая игра : " + cheapest);
    }

    private static void executeTask3() {
        System.out.println("\n--- Задание 3 (Вариант 7): Enum DayOfWeek и метод isWeekend() ---");
        for (DayOfWeek day : DayOfWeek.values()) {
            String status = day.isWeekend() ? "Выходной день" : "Рабочий день";
            System.out.printf("  %-10s (%-11s) -> %s%n", day.name(), day.getRussianName(), status);
        }
    }
}

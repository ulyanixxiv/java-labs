package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
       System.out.println("--- ЗАДАНИЕ 1: Карта студентов (Map<String, Student>) ---\n");

        Map<String, Student> studentsMap = new LinkedHashMap<>();

        Undergraduate u1 = new Undergraduate("Алексей Смирнов", 101, 4.35, 2);
        Undergraduate u2 = new Undergraduate("Мария Иванова", 102, 4.80, 1);
        Undergraduate u3 = new Undergraduate("Дмитрий Соколов", 103, 3.90, 4);
        Graduate g1 = new Graduate("Елена Кузнецова", 201, 4.95, "Машинное обучение в биоинформатике");
        Graduate g2 = new Graduate("Артем Новиков", 202, 4.40, "Распределенные микросервисные архитектуры");
        Graduate g3 = new Graduate("Ольга Федорова", 203, 4.70, "Криптографические протоколы безопасности");
        PhD p1 = new PhD("Сергей Волков", 301, 5.00, 7);
        PhD p2 = new PhD("Анна Морозова", 302, 4.85, 4);
        PhD p3 = new PhD("DDD DDD", 303, 4.77, 5);

        studentsMap.put(u1.getName(), u1);
        studentsMap.put(u2.getName(), u2);
        studentsMap.put(u3.getName(), u3);
        studentsMap.put(g1.getName(), g1);
        studentsMap.put(g2.getName(), g2);
        studentsMap.put(g3.getName(), g3);
        studentsMap.put(p1.getName(), p1);
        studentsMap.put(p2.getName(), p2);
        studentsMap.put(p3.getName(), p3);

        System.out.println("Список студентов из Map (ключ: имя, значение: объект Student):");
        int index = 1;
        for (Map.Entry<String, Student> entry : studentsMap.entrySet()) {
            System.out.printf("%2d. Ключ [\"%s\"] -> ", index++, entry.getKey());
            entry.getValue().displayInfo();
        }

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1, "La Terrazza", "Итальянская", 3, Arrays.asList(5, 5, 4, 5, 4)));     // ср: 4.60 (>= 4 -> +1 звезда)
        restaurants.add(new Restaurant(2, "Bistro Paris", "Французская", 4, Arrays.asList(4, 4, 5, 4, 4)));     // ср: 4.20 (>= 4 -> +1 звезда)
        restaurants.add(new Restaurant(3, "FastBurger", "Американская", 2, Arrays.asList(2, 3, 2, 1, 2)));      // ср: 2.00 (< 3 -> удалить)
        restaurants.add(new Restaurant(4, "Tokyo Night", "Японская", 4, Arrays.asList(5, 5, 4, 5, 5)));        // ср: 4.80 (>= 4 -> +1 звезда)
        restaurants.add(new Restaurant(5, "Snack Point", "Фастфуд", 1, Arrays.asList(3, 2, 3, 2, 2)));        // ср: 2.40 (< 3 -> удалить)
        restaurants.add(new Restaurant(6, "El Gusto", "Испанская", 3, Arrays.asList(4, 3, 4, 3, 4)));          // ср: 3.60 (остается без изменений)
        restaurants.add(new Restaurant(7, "Alpha Lounge", "Европейская", 4, Arrays.asList(4, 4, 4, 5, 4)));    // ср: 4.20 (совпадает с Bistro Paris)

        System.out.println("1. Исходный список ресторанов:");
        for (Restaurant r : restaurants) {
            r.displayInfo();
        }

        // 1. Удаление ресторанов со средним рейтингом < 3
        restaurants.removeIf(r -> r.getAverageReview() < 3.0);

        System.out.println("Список после удаления низкорейтинговых заведений:");
        for (Restaurant r : restaurants) {
            r.displayInfo();
        }

        // 2. Повышение звездности ресторанов со средним рейтингом >= 4 на 1
        for (Restaurant r : restaurants) {
            if (r.getAverageReview() >= 4.0) {
                r.setStars(r.getStars() + 1);
            }
        }
        System.out.println("Список после обновления звездности:");
        for (Restaurant r : restaurants) {
            r.displayInfo();
        }

        // 3. Вывод ресторанов с заданной звездностью (например, 4★ и 5★)
        printRestaurants(restaurants, 4);
        printRestaurants(restaurants, 5);

        // 4. Сортировка: по убыванию среднего рейтинга, при равенстве — по алфавиту по названию
        restaurants.sort(
                Comparator.comparingDouble(Restaurant::getAverageReview).reversed()
                        .thenComparing(Restaurant::getName)
        );

        System.out.println("| ID | Название         | Ср. рейтинг | Звёзды |");
        for (Restaurant r : restaurants) {
            System.out.printf("| %2d | %-16s | %11.2f | %5d★ |%n",
                    r.getId(), r.getName(), r.getAverageReview(), r.getStars());
        }
    }

    /**
     * Метод печати ресторанов с заданной звездностью.
     *
     * @param restaurants список ресторанов
     * @param stars       требуемое количество звезд
     */
    public static void printRestaurants(List<Restaurant> restaurants, int stars) {
        boolean found = false;
        for (Restaurant r : restaurants) {
            if (r.getStars() == stars) {
                r.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("  (Рестораны с такой звездностью не найдены)");
        }
    }
}

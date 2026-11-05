package org.example;

public class App {
    public static void main(String[] args) {
        Sportsman[] team = new Sportsman[5];
        team[0] = new Forward("Килиан Мбаппе", "Реал Мадрид", 9, 15);
        team[1] = new Forward("Эрлинг Холанн", "Манчестер Сити", 9, 22);
        team[2] = new Forward("Винисиус Жуниор", "Реал Мадрид", 7, 12);
        team[3] = new Goalkeeper("Тибо Куртуа", "Реал Мадрид", 1, 45);
        team[4] = new Goalkeeper("Мануэль Нойер", "Бавария", 1, 38);

        System.out.println();
        System.out.println("Список спортсменов (полиморфный вызов displayInfo):");
        for (Sportsman sportsman : team) {
            sportsman.displayInfo();
        }

        System.out.println();
        System.out.println("Демонстрация уникальных методов:");
        for (Sportsman sportsman : team) {
            if (sportsman instanceof Forward forward) {
                forward.scoreGoal();
            } else if (sportsman instanceof Goalkeeper goalkeeper) {
                goalkeeper.makeSave();
            }
        }
        goalkeeper.makeSave();
    }
}

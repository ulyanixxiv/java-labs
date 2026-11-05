package org.example;

public class App {
    public static void main(String[] args) {
        Football f1 = new Football("Реал Мадрид", "Барселона", 90, "2:1");
        Football f2 = new Football("Манчестер Сити", "Ливерпуль", 90, "3:2");

        Basketball b1 = new Basketball("Лос-Анджелес Лейкерс", "Голден Стэйт", 48, "112:108");
        Basketball b2 = new Basketball("Бостон Селтикс", "Майами Хит", 48, "105:99");
        Basketball b3 = new Basketball("Чикаго Буллз", "Нью-Йорк Никс", 48, "95:91");

        Playable[] playableGames = new Playable[] { f1, f2, b1, b2, b3 };

        for (Playable game : playableGames) {
            game.play();
            System.out.println("Время игры: " + game.getDuration() + " минут");
        }

        Scorable[] scorableGames = new Scorable[] { f1, f2, b1, b2, b3 };

        for (Scorable scorable : scorableGames) {
            scorable.score();
            System.out.println("Финальный счет: " + scorable.getScore());
        }

        f1.displayInfo();
        f2.displayInfo();
        b1.displayInfo();
        b2.displayInfo();
        b3.displayInfo();
    }
}

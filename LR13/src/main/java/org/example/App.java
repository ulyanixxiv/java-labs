package org.example;

public class App {
    public static void main(String[] args) {

        FilmCatalog catalog = new FilmCatalog();
        try {
            Film f1 = new Film("Интерстеллар", "Кристофер Нолан", 2014, 8.7, "Фантастика");
            Film f2 = new Film("Начало", "Кристофер Нолан", 2010, 8.8, "Фантастика");
            Film f3 = new Film("Криминальное чтиво", "Квентин Тарантино", 1994, 8.9, "Криминал");
            Film f4 = new Film("Зеленая миля", "Фрэнк Дарабонт", 1999, 9.1, "Драма");
            Film f5 = new Film("Дюна: Часть вторая", "Дени Вильнёв", 2024, 8.6, "Фантастика");

            catalog.addFilm(f1);
            catalog.addFilm(f2);
            catalog.addFilm(f3);
            catalog.addFilm(f4);
            catalog.addFilm(f5);

            System.out.println("Все фильмы успешно добавлены в каталог.\n");
            catalog.printCatalog();
        } catch (InvalidFilmDataException e) {
            System.err.println("Ошибка при начальной инициализации фильмов: " + e.getMessage());
        }

        // Тест А: год выпуска вне допустимого диапазона (1900 - 2025)
        try {
            Film invalidYearFilm = new Film("Прибытие поезда", "Братья Люмьер", 1888, 7.5, "Документальный");
            catalog.addFilm(invalidYearFilm);
        } catch (InvalidFilmDataException e) {
            System.out.printf("   [Перехвачено InvalidFilmDataException]: %s%n", e.getMessage());
        }

        // Тест Б: рейтинг вне допустимого диапазона (1.0 - 10.0)
        try {
            Film invalidRatingFilm = new Film("Супер Фильм", "Иван Иванов", 2020, 11.5, "Комедия");
            catalog.addFilm(invalidRatingFilm);
        } catch (InvalidFilmDataException e) {
            System.out.printf("   [Перехвачено InvalidFilmDataException]: %s%n", e.getMessage());
        }

        // Успешный поиск
        try {
            int searchYear = 2014;
            System.out.printf("Поиск фильма %d года выпуска:%n", searchYear);
            Film found = catalog.getFilmByYear(searchYear);
            System.out.print("   Успешно найден: ");
            found.displayInfo();
        } catch (FilmNotFoundException e) {
            System.out.printf("   [Перехвачено FilmNotFoundException]: %s%n", e.getMessage());
        }

        // Поиск несуществующего фильма
        try {
            int searchYear = 1975;
            System.out.printf("\nПоиск фильма %d года выпуска:%n", searchYear);
            Film found = catalog.getFilmByYear(searchYear);
            found.displayInfo();
        } catch (FilmNotFoundException e) {
            System.out.printf("   [Перехвачено FilmNotFoundException]: %s%n", e.getMessage());
        }


        try {
            Film interstellar = catalog.findFilmByTitle("Интерстеллар");

            System.out.println("Корректное обновление рейтинга:");
            interstellar.updateRating(8.9);

            System.out.println("\nПопытка установить некорректный рейтинг (15.0):");
            interstellar.updateRating(15.0);
        } catch (FilmNotFoundException | RatingUpdateException e) {
            System.out.printf("   [Перехвачено исключение]: %s%n", e.getMessage());
        }

        try {
            System.out.println("Выполняется блок try...");
            Film film = catalog.findFilmByTitle("Несуществующий фильм");
            film.displayInfo();
        } catch (FilmNotFoundException e) {
            System.out.printf("Блок catch: перехвачено исключение -> %s%n", e.getMessage());
        } finally {
            System.out.println("Блок finally: выполняется ВСЕГДА (даже при возникновении исключения).");
        }

    }
}

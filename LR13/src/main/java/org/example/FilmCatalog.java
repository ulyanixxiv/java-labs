package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilmCatalog {
    private final List<Film> films = new ArrayList<>();

    public void addFilm(Film film) {
        if (film != null) {
            films.add(film);
        }
    }

    public List<Film> getFilms() {
        return Collections.unmodifiableList(films);
    }

    /**
     * Поиск первого фильма указанного года выпуска.
     *
     * @param year год выпуска
     * @return найденный фильм
     * @throws FilmNotFoundException если фильмов указанного года нет или коллекция пуста
     */
    public Film getFilmByYear(int year) throws FilmNotFoundException {
        if (films.isEmpty()) {
            throw new FilmNotFoundException("Каталог фильмов пуст. Поиск невозможен.");
        }
        for (Film film : films) {
            if (film.getYear() == year) {
                return film;
            }
        }
        throw new FilmNotFoundException(
                String.format("Фильм %d года выпуска в каталоге не найден.", year));
    }

    /**
     * Поиск фильма по точному названию (без учета регистра).
     *
     * @param title название фильма
     * @return найденный фильм
     * @throws FilmNotFoundException если фильм с таким названием не найден
     */
    public Film findFilmByTitle(String title) throws FilmNotFoundException {
        if (films.isEmpty()) {
            throw new FilmNotFoundException("Каталог фильмов пуст. Поиск невозможен.");
        }
        for (Film film : films) {
            if (film.getTitle().equalsIgnoreCase(title)) {
                return film;
            }
        }
        throw new FilmNotFoundException(
                String.format("Фильм с названием «%s» не найден.", title));
    }

    public void printCatalog() {
        if (films.isEmpty()) {
            System.out.println("Каталог пуст.");
            return;
        }
        System.out.println("| №  | Название               | Режиссер           | Год  | Жанр         | Рейтинг |");
        int idx = 1;
        for (Film f : films) {
            System.out.printf("| %2d | %-22s | %-18s | %4d | %-12s |  %4.1f   |%n",
                    idx++, f.getTitle(), f.getDirector(), f.getYear(), f.getGenre(), f.getRating());
        }
    }
}

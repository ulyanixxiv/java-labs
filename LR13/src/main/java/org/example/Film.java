package org.example;

public class Film {
    private String title;
    private String director;
    private int year;
    private double rating;
    private String genre;

    public Film(String title, String director, int year, double rating, String genre)
            throws InvalidFilmDataException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidFilmDataException("Название фильма не может быть пустым.");
        }
        if (director == null || director.trim().isEmpty()) {
            throw new InvalidFilmDataException("Имя режиссера не может быть пустым.");
        }
        if (year < 1900 || year > 2025) {
            throw new InvalidFilmDataException(
                    String.format("Недопустимый год выпуска: %d. Год должен быть в диапазоне от 1900 до 2025.", year));
        }
        if (rating < 1.0 || rating > 10.0) {
            throw new InvalidFilmDataException(
                    String.format("Недопустимый рейтинг: %.2f. Рейтинг должен быть в диапазоне от 1.0 до 10.0.", rating));
        }

        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws InvalidFilmDataException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidFilmDataException("Название фильма не может быть пустым.");
        }
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) throws InvalidFilmDataException {
        if (director == null || director.trim().isEmpty()) {
            throw new InvalidFilmDataException("Имя режиссера не может быть пустым.");
        }
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidFilmDataException {
        if (year < 1900 || year > 2025) {
            throw new InvalidFilmDataException(
                    String.format("Недопустимый год выпуска: %d. Диапазон: [1900; 2025].", year));
        }
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Обновление рейтинга фильма с проверкой диапазона [1.0; 10.0].
     *
     * @param newRating новое значение рейтинга
     * @throws RatingUpdateException если рейтинг выходит за допустимые границы
     */
    public void updateRating(double newRating) throws RatingUpdateException {
        if (newRating < 1.0 || newRating > 10.0) {
            throw new RatingUpdateException(
                    String.format("Не удалось обновить рейтинг фильма «%s»: значение %.2f выходит за пределы [1.0; 10.0].",
                            title, newRating));
        }
        double oldRating = this.rating;
        this.rating = newRating;
        System.out.printf("Рейтинг фильма «%s» успешно обновлен: %.2f -> %.2f%n", title, oldRating, this.rating);
    }

    public void displayInfo() {
        System.out.printf("Фильм: «%-22s» | Режиссер: %-18s | Год: %4d | Жанр: %-12s | Рейтинг: %4.1f/10%n",
                title, director, year, genre, rating);
    }

    @Override
    public String toString() {
        return String.format("Film[title='%s', director='%s', year=%d, genre='%s', rating=%.1f]",
                title, director, year, genre, rating);
    }
}

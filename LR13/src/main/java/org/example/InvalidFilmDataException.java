package org.example;

/**
 * Исключение, выбрасываемое при некорректных входных данных фильма
 * (например, недопустимый год выпуска или выходящий за границы рейтинг).
 */
public class InvalidFilmDataException extends Exception {
    public InvalidFilmDataException(String message) {
        super(message);
    }

    public InvalidFilmDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

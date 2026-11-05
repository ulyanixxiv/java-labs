package org.example;

/**
 * Исключение, выбрасываемое, если фильм по заданному критерию (году, названию)
 * не найден в коллекции или коллекция пуста.
 */
public class FilmNotFoundException extends Exception {
    public FilmNotFoundException(String message) {
        super(message);
    }

    public FilmNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

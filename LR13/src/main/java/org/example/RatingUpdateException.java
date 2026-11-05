package org.example;

/**
 * Исключение, выбрасываемое при ошибке обновления рейтинга фильма
 * (например, значение вне допустимого диапазона 1.0 - 10.0).
 */
public class RatingUpdateException extends Exception {
    public RatingUpdateException(String message) {
        super(message);
    }

    public RatingUpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}

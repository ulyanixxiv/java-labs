package org.example;

public class Game {
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

    public void displayInfo() {
        System.out.printf("«%-16s» | Жанр: %-13s | Цена: %.2f руб.%n",
                title, genre, price);
    }
}
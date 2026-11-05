package org.example;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private String cuisine;
    private int stars;
    private List<Integer> customerReviews;

    public Restaurant(int id, String name, String cuisine, int stars, List<Integer> customerReviews) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.stars = stars;
        this.customerReviews = (customerReviews != null) ? new ArrayList<>(customerReviews) : new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Integer> getCustomerReviews() {
        return customerReviews;
    }

    public void setCustomerReviews(List<Integer> customerReviews) {
        this.customerReviews = (customerReviews != null) ? new ArrayList<>(customerReviews) : new ArrayList<>();
    }

    public double getAverageReview() {
        if (customerReviews == null || customerReviews.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int review : customerReviews) {
            sum += review;
        }
        return (double) sum / customerReviews.size();
    }

    public void displayInfo() {
        System.out.printf("Ресторан [ID: %2d] «%-16s» | Кухня: %-12s | Звёзды: %d★ | Оценки: %s | Ср. рейтинг: %.2f%n",
                id, name, cuisine, stars, customerReviews, getAverageReview());
    }

    @Override
    public String toString() {
        return String.format("Restaurant[id=%d, name='%s', cuisine='%s', stars=%d, avgRating=%.2f]",
                id, name, cuisine, stars, getAverageReview());
    }
}

package org.example;

public class Food extends Product {
    private int expirationDays;

    public Food(String name, double price, double weight, int expirationDays) {
        super(name, price, weight);
        this.expirationDays = expirationDays;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public void setExpirationDays(int expirationDays) {
        this.expirationDays = expirationDays;
    }

    @Override
    public double getDiscount() {
        return 15.0;
    }

    public void sell(boolean isFresh) {
        System.out.printf("Продаю продукт питания «%s» (%s, срок годности: %d дн.)%n",
                getName(), isFresh ? "свежая поставка" : "скидка по акции", expirationDays);
    }

    @Override
    public void displayInfo() {
        System.out.printf("Продукт питания: %-7s | Цена: %8.2f руб. | Вес: %5.2f кг | Скидка: %.1f%% | Срок: %d дн.%n",
                getName(), getPrice(), getWeight(), getDiscount(), expirationDays);
    }
}

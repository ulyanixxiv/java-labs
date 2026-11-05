package org.example;

public class Product {
    private String name;
    private double price;
    private double weight;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void sell() {
        System.out.println("Продаю товар: " + name);
    }

    public void sell(int quantity) {
        double total = price * quantity;
        System.out.printf("Продаю %d шт. товара «%s» на сумму: %.2f руб.%n", quantity, name, total);
    }

    public void sell(double discount) {
        double discountedPrice = price * (1.0 - discount / 100.0);
        System.out.printf("Продаю со скидкой %.1f%% товар «%s» по цене: %.2f руб.%n", discount, name, discountedPrice);
    }

    public double getDiscount() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.printf("Товар: %-16s | Цена: %8.2f руб. | Вес: %5.2f кг | Базовая скидка: %.1f%%%n",
                name, price, weight, getDiscount());
    }
}

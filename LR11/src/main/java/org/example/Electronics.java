package org.example;

public class Electronics extends Product {
    private int warranty;

    public Electronics(String name, double price, double weight, int warranty) {
        super(name, price, weight);
        this.warranty = warranty;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    @Override
    public double getDiscount() {
        return 5.0;
    }

    public void sell(String customerName) {
        System.out.printf("Продаю электронику «%s» покупателю %s (гарантия: %d мес.)%n",
                getName(), customerName, warranty);
    }

    @Override
    public void displayInfo() {
        System.out.printf("Электроника: %-11s | Цена: %8.2f руб. | Вес: %5.2f кг | Скидка: %.1f%% | Гарантия: %d мес.%n",
                getName(), getPrice(), getWeight(), getDiscount(), warranty);
    }
}

package org.example;

public class App {
    public static void main(String[] args) {
        Product baseProduct = new Product("Книга", 25.0, 0.4);
        Electronics laptop = new Electronics("Ноутбук Asus", 2400.0, 1.8, 24);
        Food apple = new Food("Яблоки Голден", 4.50, 1.0, 14);

        baseProduct.sell();
        baseProduct.sell(3);
        baseProduct.sell(10.0);

        System.out.println();
        laptop.sell();
        laptop.sell(2);
        laptop.sell("Иван Петров"); // перегруженный метод класса Electronics

        System.out.println();
        apple.sell();
        apple.sell(5);
        apple.sell(true); // перегруженный метод класса Food

        Product[] catalog = new Product[] { baseProduct, laptop, apple };

        for (Product item : catalog) {
            item.displayInfo();
            System.out.printf("   -> Применяемая скидка для «%s»: %.1f%%%n", item.getName(), item.getDiscount());
        }

        System.out.println("• Статический (перегрузка sell): решение о том, какой метод вызвать, принимается компилятором по сигнатуре.");
        System.out.println("• Динамический (переопределение getDiscount): решение принимается JVM во время выполнения по фактическому типу объекта.");
    }
}

package org.example;

public class App {
    public static void main(String[] args) {
        Apartment apt1 = new Apartment("ул. Ленина, 15", 2, 54.5);
        Apartment apt2 = new Apartment("пр. Независимости, 40", 3, 78.0);

        apt1.displayInfo(163500.0);
        apt2.displayInfo(273000.0);

        apt1.setAddress("ул. Ленина, 15, кв. 8");
        apt1.setRooms(3);
        apt1.setArea(65.0);

        System.out.println("\nПосле изменения через сеттеры:");
        System.out.println("Адрес: " + apt1.getAddress());
        System.out.println("Комнат: " + apt1.getRooms());
        System.out.println("Площадь: " + apt1.getArea());
        System.out.printf("Цена за квадратный метр: %.2f руб.%n", apt1.pricePerSquareMeter(195000.0));
    }
}

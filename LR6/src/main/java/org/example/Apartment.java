package org.example;

public class Apartment {
    private String address;
    private int rooms;
    private double area;

    public Apartment(String address, int rooms, double area) {
        this.address = address;
        this.rooms = rooms;
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double pricePerSquareMeter(double totalPrice) {
        return totalPrice / area;
    }

    public void displayInfo(double totalPrice) {
        System.out.printf("Квартира: адрес = %s | комнат = %d | площадь = %.2f кв.м | цена за кв.м = %.2f руб.%n",
                address, rooms, area, pricePerSquareMeter(totalPrice));
    }
}

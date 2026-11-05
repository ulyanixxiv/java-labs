package org.example;

public abstract class Account {
    private String number;
    private double balance;
    private String owner;

    public Account(String number, double balance, String owner) {
        this.number = number;
        this.balance = balance;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    // Абстрактные методы
    public abstract double calculateInterest();
    public abstract void withdraw(double amount);

    // Конкретный метод
    public void displayInfo() {
        System.out.printf("Счет: %-12s | Владелец: %-16s | Баланс: %10.2f руб.",
                number, owner, balance);
    }
}

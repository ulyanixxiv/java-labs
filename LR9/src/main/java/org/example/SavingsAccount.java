package org.example;

public class SavingsAccount extends Account {
    private double rate; // Процентная ставка

    public SavingsAccount(String number, double balance, String owner, double rate) {
        super(number, balance, owner);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * rate / 100.0;
    }

    @Override
    public void withdraw(double amount) {
        double fee = amount * 0.01; // комиссия 1%
        double total = amount + fee;
        if (getBalance() >= total) {
            setBalance(getBalance() - total);
            System.out.printf("Снятие со сберегательного счета %s: %.2f руб. (комиссия 1%% = %.2f руб.). Новый баланс: %.2f руб.%n",
                    getNumber(), amount, fee, getBalance());
        } else {
            System.out.printf("Ошибка снятия: на счете %s недостаточно средств для суммы %.2f руб. с комиссией 1%%!%n",
                    getNumber(), amount);
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(" | Тип: Сберегательный (ставка: %.1f%%) | Начисленные %%: %8.2f руб.%n",
                rate, calculateInterest());
    }
}

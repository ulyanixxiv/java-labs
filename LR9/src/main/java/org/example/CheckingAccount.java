package org.example;

public class CheckingAccount extends Account {
    private double overdraftLimit; // Лимит овердрафта

    public CheckingAccount(String number, double balance, String owner, double overdraftLimit) {
        super(number, balance, owner);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return 0.0; // Без процентов
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            setBalance(getBalance() - amount);
            System.out.printf("Снятие с расчетного счета %s: %.2f руб. (без комиссии). Новый баланс: %.2f руб.%n",
                    getNumber(), amount, getBalance());
        } else {
            System.out.printf("Ошибка снятия: превышен лимит овердрафта на счете %s для суммы %.2f руб.!%n",
                    getNumber(), amount);
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf(" | Тип: Расчетный     (овердрафт: %7.2f руб.) | Без процентов%n",
                overdraftLimit);
    }
}

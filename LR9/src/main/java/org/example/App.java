package org.example;

public class App {
    public static void main(String[] args) {
        System.out.println("ЛАБОРАТОРНАЯ РАБОТА № 9 (Вариант 7: Банковские счета)");

        Account[] accounts = new Account[5];
        accounts[0] = new SavingsAccount("BY01SAV001", 5000.0, "Алексей Иванов", 12.5);
        accounts[1] = new SavingsAccount("BY01SAV002", 12000.0, "Елена Смирнова", 14.0);
        accounts[2] = new CheckingAccount("BY02CHK001", 3500.0, "ООО «ТехноПром»", 2000.0);
        accounts[3] = new CheckingAccount("BY02CHK002", 800.0, "ИП Кузнецов", 1500.0);
        accounts[4] = new CheckingAccount("BY02CHK003", 15000.0, "ЗАО «СтройГрупп»", 5000.0);

        System.out.println();
        System.out.println("Список банковских счетов (полиморфный вызов displayInfo):");
        for (Account account : accounts) {
            account.displayInfo();
        }

        System.out.println();
        System.out.println("Расчет процентов по всем счетам (метод calculateInterest):");
        for (Account account : accounts) {
            System.out.printf("Счет %s (%s): начислено процентов = %.2f руб.%n",
                    account.getNumber(), account.getOwner(), account.calculateInterest());
        }

        System.out.println();
        System.out.println("Демонстрация операций снятия (withdraw):");
        accounts[0].withdraw(1000.0); // Сберегательный: с комиссией 1%
        accounts[2].withdraw(4000.0); // Расчетный: без комиссии (с учетом овердрафта)
    }
}

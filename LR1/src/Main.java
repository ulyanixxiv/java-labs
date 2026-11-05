import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1 Перевести дюймы в сантиметры");
            System.out.println("2 Найти наименьшее из трех чисел");
            System.out.println("3 Таблица умножения числа от 1 до 10");
            System.out.println("0 Выход из программы");
            System.out.print("Выберите пункт меню: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите значение в дюймах: ");
                    double inches = scanner.nextDouble();
                    double centimeters = inches * 2.54;
                    System.out.println(inches + " дюйм(ов) = " + centimeters + " см");
                    break;

                case 2:
                    System.out.print("Введите первое число (A): ");
                    double a = scanner.nextDouble();
                    System.out.print("Введите второе число (B): ");
                    double b = scanner.nextDouble();
                    System.out.print("Введите третье число (C): ");
                    double c = scanner.nextDouble();
                    double min = a;
                    if (b < min) {
                        min = b;
                    }
                    if (c < min) {
                        min = c;
                    }
                    System.out.println("Наименьшее число среди введенных: " + min);
                    break;

                case 3:
                    System.out.print("Введите целое число: ");
                    int num = scanner.nextInt();
                    System.out.println("Таблица умножения для " + num + ":");
//                    for (int i = 1; i <= 10; i++) {
//                        System.out.println(num + " * " + i + " = " + (num * i));
//                    }

                    int i = 1;
                    do {
                        System.out.println(num + " * " + i + " = " + (num * i));
                        i++;
                    } while (i <= 10);


                    break;

                case 0:
                    System.out.println("Работа программы завершена.");
                    break;

                default:
                    System.out.println("Ошибка: неверный пункт меню! Введите число от 0 до 3.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
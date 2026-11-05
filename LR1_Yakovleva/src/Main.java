import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Гипотенуза по двум катетам");
            System.out.println("2. Проверка кратности 3 или 7");
            System.out.println("3. Двоичное представление числа");
            System.out.println("4. Узнать столицу страны");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Введите длину первого катета (a): ");
                    double a = scanner.nextDouble();
                    System.out.print("Введите длину второго катета (b): ");
                    double b = scanner.nextDouble();

                    double c = Math.sqrt(a * a + b * b);
                    System.out.printf("Гипотенуза c = %.4f%n", c);
                    break;
                }
                case 2: {
                    System.out.print("Введите целое число: ");
                    int number = scanner.nextInt();

                    boolean divBy3 = (number % 3 == 0);
                    boolean divBy7 = (number % 7 == 0);

                    if (divBy3 || divBy7) {
                        System.out.println("Число " + number + " кратно 3 или 7.");
                    } else {
                        System.out.println("Число " + number + " НЕ кратно ни 3, ни 7.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Введите целое положительное число (или 0): ");
                    int num = scanner.nextInt();

                    if (num == 0) {
                        System.out.println("Двоичное представление: 0");
                        break;
                    }

                    int temp = Math.abs(num);
                    String binary = "";

                    while (temp > 0) {
                        int remainder = temp % 2;
                        binary = remainder + binary;
                        temp /= 2;
                    }

                    if (num < 0) {
                        binary = "-" + binary;
                    }

                    System.out.println("Двоичное представление: " + binary);
                    break;
                }
                case 4:
                {
                    scanner.nextLine();
                    System.out.print("Введите название страны: ");
                    String country = scanner.nextLine().trim().toLowerCase();
                    String capital = switch(country)
                    {
                        case "россия" -> "Москва";
                        default -> null;
                    };
                    if (capital != null) {
                        System.out.println("Столица страны: " + capital);
                    }
                    else {
                        System.out.println("Ошибка");
                    }
                    break;

                }
                case 0:
                    System.out.println("Выход из программы.");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Повторите ввод.");
                    break;
            }

        }

        scanner.close();
    }
}
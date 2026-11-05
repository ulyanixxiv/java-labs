import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Employee {
    private String fullname;
    private double salary;

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getFullname() {
        return fullname;
    }
    public double getSalary() {
        return salary;
    }
}

class Report {
    public static void generateReport(Employee[] employees) {
        System.out.println("           ОТЧЕТ ПО ЗАРПЛАТАМ           ");
        System.out.printf("%-15s | %12s%n", "Фамилия", "Оклад (руб.)");
        for (Employee emp : employees) {
            System.out.printf("%-15s | %12.2f%n", emp.getFullname(), emp.getSalary());
        }
    }
}

public class LR3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("1. Задание 1: Проверить, состоит ли строка только из пробелов");
            System.out.println("2. Задание 2: Удалить все гласные буквы из строки");
            System.out.println("3. Задание 3: Отчет о зарплате сотрудников");
            System.out.println("4. Задание 4: Поиск кириллических слов по шаблону");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    executeTask1(scanner);
                    break;
                case 2:
                    executeTask2(scanner);
                    break;
                case 3:
                    executeTask3();
                    break;
                case 4:
                    executeTask4(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    break;
                default:
                    System.out.println("Неверный пункт меню, попробуйте снова.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void executeTask1(Scanner scanner) {
        System.out.print("Введите тестируемую строку (или нажмите Enter на пустой строке): ");
        String input = scanner.nextLine();

        boolean isOnlyWhitespace = input.isBlank();

        System.out.println("Анализ строки: \"" + input + "\"");
        System.out.println("Длина строки (length): " + input.length());
        if (isOnlyWhitespace) {
            System.out.println("Строка либо пустая, либо состоит исключительно из пробельных символов.");
        } else {
            System.out.println("Строка содержит значащие непробельные символы.");
        }
    }

    private static void executeTask2(Scanner scanner) {
        System.out.print("Введите текст: ");
        String input = scanner.nextLine();

        String regex = "[аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY]";
        String result = input.replaceAll(regex, "");

        System.out.println("Исходная строка : " + input);
        System.out.println("Результат: " + result);
    }

    private static void executeTask3() {

        Employee[] employees = new Employee[] {
            new Employee("Иванов", 2450.50),
            new Employee("Петров", 1890.00),
            new Employee("Сидорова", 3200.75),
            new Employee("Ковалев", 2150.20),
            new Employee("Александров", 4500.00)
        };

        Report.generateReport(employees);
    }

    private static void executeTask4(Scanner scanner) {
        String defaultText = "ааа ббб ёёё ззз ййй ААА БББ ЁЁЁ ЗЗЗ ЙЙЙ";
        System.out.println("Тестовая строка:");
        System.out.println("\"" + defaultText + "\"");

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(defaultText);

        System.out.println("\nНайденные слова по шаблону [а-яА-ЯёЁ]+:");
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.printf("%2d) Слово: %-8s (позиция в строке: [%d; %d])%n", 
                count, matcher.group(), matcher.start(), matcher.end());
        }
        System.out.println("Всего найдено кириллических слов: " + count);
    }
}
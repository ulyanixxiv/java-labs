import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Вспомогательный класс Employee для Задания 3
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

// Вспомогательный класс Report со статическим методом generateReport для Задания 3
class Report {
    public static void generateReport(Employee[] employees) {
        System.out.println("\n----------------------------------------");
        System.out.println("           ОТЧЕТ ПО ЗАРПЛАТАМ           ");
        System.out.println("----------------------------------------");
        System.out.printf("%-15s | %12s%n", "Фамилия", "Оклад (руб.)");
        System.out.println("----------------+-----------------------");
        for (Employee emp : employees) {
            // Форматирование: 15 символов под фамилию, выравнивание оклада по правому краю с 2 знаками
            System.out.printf("%-15s | %12.2f%n", emp.getFullname(), emp.getSalary());
        }
        System.out.println("----------------------------------------");
    }
}

public class LR3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==================================================================");
            System.out.println("   ЛАБОРАТОРНАЯ РАБОТА № 3 (Вариант 7)");
            System.out.println("==================================================================");
            System.out.println("1. Задание 1: Проверить, состоит ли строка только из пробелов (isBlank)");
            System.out.println("2. Задание 2: Удалить все гласные буквы из строки (replaceAll + regex)");
            System.out.println("3. Задание 3: Отчет о зарплате сотрудников (Employee & Report.generateReport)");
            System.out.println("4. Задание 4: Поиск кириллических слов по шаблону (Pattern & Matcher)");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // считываем остаток строки после nextInt()

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
                    System.out.println("Выход из программы Лабораторной работы № 3.");
                    break;
                default:
                    System.out.println("Неверный пункт меню! Попробуйте снова.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    /**
     * Задание 1 (Вариант 7):
     * Проверить, состоит ли строка только из пробелов (isBlank()).
     */
    private static void executeTask1(Scanner scanner) {
        System.out.println("\n--- Задание 1. Вариант 7: Проверка строки на пробелы (isBlank) ---");
        System.out.print("Введите тестируемую строку (или нажмите Enter на пустой строке): ");
        String input = scanner.nextLine();

        boolean isOnlyWhitespace = input.isBlank();

        System.out.println("Анализ строки: \"" + input + "\"");
        System.out.println("Длина строки (length): " + input.length());
        System.out.println("Результат input.isBlank(): " + isOnlyWhitespace);
        if (isOnlyWhitespace) {
            System.out.println("Вывод: строка либо пустая, либо состоит исключительно из пробельных символов.");
        } else {
            System.out.println("Вывод: строка содержит значащие непробельные символы.");
        }
    }

    /**
     * Задание 2 (Вариант 7):
     * Удалить все гласные буквы из строки (использовать replaceAll с регулярным выражением).
     */
    private static void executeTask2(Scanner scanner) {
        System.out.println("\n--- Задание 2. Вариант 7: Удаление гласных букв через replaceAll ---");
        System.out.print("Введите текст: ");
        String input = scanner.nextLine();

        // Регулярное выражение для всех русских и английских гласных (регистронезависимо через (?ui) или перечисление)
        String regex = "[аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouyAEIOUY]";
        String result = input.replaceAll(regex, "");

        System.out.println("Исходная строка : " + input);
        System.out.println("Результат замены: " + result);
    }

    /**
     * Задание 3:
     * Класс Employee (fullname, salary), массив объектов и статический метод Report.generateReport().
     */
    private static void executeTask3() {
        System.out.println("\n--- Задание 3: Форматированный отчет о зарплате сотрудников ---");

        Employee[] employees = new Employee[] {
            new Employee("Иванов", 2450.50),
            new Employee("Петров", 1890.00),
            new Employee("Сидорова", 3200.75),
            new Employee("Ковалев", 2150.20),
            new Employee("Александров", 4500.00)
        };

        Report.generateReport(employees);
    }

    /**
     * Задание 4 (Вариант 7):
     * Дана строка 'ааа ббб ёёё ззз ййй ААА БББ ЁЁЁ ЗЗЗ ЙЙЙ'.
     * Найти и вывести все слова по шаблону: любая кириллическая буква любое количество раз.
     */
    private static void executeTask4(Scanner scanner) {
        System.out.println("\n--- Задание 4. Вариант 7: Поиск кириллических слов (Pattern & Matcher) ---");
        String defaultText = "ааа ббб ёёё ззз ййй ААА БББ ЁЁЁ ЗЗЗ ЙЙЙ 123 abc !!! привет мир";
        System.out.println("Тестовая строка из методички с добавлением других символов:");
        System.out.println("\"" + defaultText + "\"");

        // Шаблон: любая буква кириллицы (включая букву ё/Ё) один или более раз
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

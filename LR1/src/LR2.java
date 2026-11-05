import java.util.Scanner;

public class LR2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n======================================================");
            System.out.println("   ЛАБОРАТОРНАЯ РАБОТА № 2 (Вариант 7)");
            System.out.println("======================================================");
            System.out.println("1. Задание 1: Найти индекс минимального элемента в одномерном массиве");
            System.out.println("2. Задание 2: Найти максимум в каждом столбце матрицы");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт меню: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число!");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    executeTask1(scanner);
                    break;
                case 2:
                    executeTask2(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы Лабораторной работы № 2.");
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
     * Найти индекс минимального элемента.
     */
    private static void executeTask1(Scanner scanner) {
        System.out.println("\n--- Задание 1. Вариант 7: Поиск индекса минимального элемента ---");
        System.out.print("Введите размерность массива N: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Размер массива должен быть больше 0!");
            return;
        }

        int[] mas = new int[n];
        System.out.println("Введите " + n + " элементов массива через пробел или Enter:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }

        // Вывод элементов массива с использованием mas.length
        System.out.print("Исходный одномерный массив: [");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + (i < mas.length - 1 ? ", " : ""));
        }
        System.out.println("]");

        // Поиск минимального значения и его индекса
        int minVal = mas[0];
        int minIndex = 0;

        for (int i = 1; i < mas.length; i++) {
            if (mas[i] < minVal) {
                minVal = mas[i];
                minIndex = i;
            }
        }

        System.out.println("Результат:");
        System.out.println("  Минимальный элемент: " + minVal);
        System.out.println("  Индекс минимального элемента: " + minIndex);
    }

    /**
     * Задание 2 (Вариант 7):
     * Найти максимум в каждом столбце матрицы.
     * Обязательно используются mas.length и mas[i].length.
     */
    private static void executeTask2(Scanner scanner) {
        System.out.println("\n--- Задание 2. Вариант 7: Поиск максимума в каждом столбце матрицы ---");
        System.out.print("Введите количество строк матрицы (M): ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы (N): ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Размеры матрицы должны быть положительными!");
            return;
        }

        int[][] mas = new int[rows][cols];

        System.out.println("Выберите способ заполнения матрицы:");
        System.out.println("1. Ввести вручную");
        System.out.println("2. Заполнить случайными числами от -50 до 50");
        System.out.print("Ваш выбор: ");
        int fillChoice = scanner.nextInt();

        if (fillChoice == 1) {
            System.out.println("Введите элементы матрицы (" + rows + " строк по " + cols + " чисел):");
            // Использование mas.length, а потом mas[i].length при заполнении
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = scanner.nextInt();
                }
            }
        } else {
            // Использование mas.length, а потом mas[i].length при генерации
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = (int) (Math.random() * 101) - 50;
                }
            }
        }

        // Вывод исходной матрицы: mas.length, затем mas[i].length
        System.out.println("\nИсходная матрица (" + mas.length + " строк x " + mas[0].length + " столбцов):");
        for (int i = 0; i < mas.length; i++) {
            System.out.printf("Строка %d: ", i);
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf("%6d", mas[i][j]);
            }
            System.out.println();
        }

        // Поиск максимума в каждом столбце матрицы
        System.out.println("\nМаксимумы в столбцах:");
        int totalCols = mas[0].length;

        for (int j = 0; j < totalCols; j++) {
            int maxCol = mas[0][j];
            int maxRowIndex = 0;

            for (int i = 1; i < mas.length; i++) {
                if (mas[i][j] > maxCol) {
                    maxCol = mas[i][j];
                    maxRowIndex = i;
                }
            }
            System.out.printf("  Столбец %d: максимальный элемент = %d (в строке %d)%n", j, maxCol, maxRowIndex);
        }
    }
}

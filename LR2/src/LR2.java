import java.util.Scanner;

public class LR2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Задание 1: Найти индекс минимального элемента в массиве");
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
        System.out.print("Введите размерность массива N: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Размер массива должен быть больше 0!");
            return;
        }
        int[] mas = new int[n];
        System.out.println("Введите " + n + " элементов массива через пробел или Enter:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 9+1);
            // mas[i] = scanner.nextInt();
        }

        System.out.print("Исходный одномерный массив: [");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + (i < mas.length - 1 ? ", " : ""));
        }
        System.out.println("]");

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


    private static void executeTask2(Scanner scanner) {
        System.out.print("Введите количество строк матрицы (M): ");
        int rows = scanner.nextInt();
        System.out.print("Введите количество столбцов матрицы (N): ");
        int cols = scanner.nextInt();

        if (rows <= 0 || cols <= 0) {
            System.out.println("Размеры матрицы должны быть положительными!");
            return;
        }

        int[][] mas = new int[rows][cols];

        int totalelements = mas.length * mas[0].length;
        System.out.println("Введите элементы матрицы (" + totalelements + " чисел через пробел или Enter):");
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; i < mas[i].length; j++) {
                mas[i][j] = scanner.nextInt();
            }
        }

        System.out.println("\nИсходная матрица (" + rows + " строк x " + cols + " столбцов):");
        for (int i = 0; i < rows; i++) {
            System.out.printf("Строка %d: ", i);
            for (int j = 0; j < cols; j++) {
                System.out.printf("%6d", mas[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nМаксимумы в столбцах:");
        for (int j = 0; j < cols; j++) {
            int maxCol = mas[0][j];
            int maxRowIndex = 0;

            for (int i = 1; i < rows; i++) {
                if (mas[i][j] > maxCol) {
                    maxCol = mas[i][j];
                    maxRowIndex = i;
                }
            }
            System.out.printf("  Столбец %d: максимальный элемент = %d (в строке %d)%n", j, maxCol, maxRowIndex);
        }
    }}

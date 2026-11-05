package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("          ЛАБОРАТОРНАЯ РАБОТА № 14: ФАЙЛОВЫЙ ВВОД И ВЫВОД В JAVA");
        System.out.println("                                ВАРИАНТ 7");
        System.out.println("================================================================================\n");

        // Папка для выходных файлов лабораторной работы
        String dataDir = "data" + File.separator;
        new File(dataDir).mkdirs();

        try {
            // -------------------------------------------------------------------------
            // ЗАДАНИЕ 1: Файл с информацией о семье, метаданные и чтение
            // -------------------------------------------------------------------------
            System.out.println("--- ЗАДАНИЕ 1: Информация о семье и свойства файла ---");
            FamilyFileManager familyManager = new FamilyFileManager(dataDir + "family_info.txt");
            familyManager.addMember(new FamilyMember("Александр", "Отец", 48, "Инженер-конструктор"));
            familyManager.addMember(new FamilyMember("Елена", "Мать", 46, "Преподаватель математики"));
            familyManager.addMember(new FamilyMember("Дмитрий", "Сын (студент)", 19, "Будущий программист"));
            familyManager.addMember(new FamilyMember("София", "Дочь (школьница)", 12, "Ученица гимназии"));

            familyManager.saveToFile();
            System.out.println("Файл успешно создан и записан: " + familyManager.getFilePath() + "\n");

            familyManager.printFileMetadata();
            System.out.println();
            familyManager.printFileContent();

            System.out.println("\n--------------------------------------------------------------------------------");

            // -------------------------------------------------------------------------
            // ЗАДАНИЕ 2: Запись 10 целых чисел в файл 'f', чтение и подсчет положительных
            // -------------------------------------------------------------------------
            System.out.println("--- ЗАДАНИЕ 2: 10 целых чисел в файл 'f', подсчет положительных ---");
            NumberFileManager numberManager = new NumberFileManager(dataDir + "task2_f.txt");

            // 10 целых чисел (содержат положительные, отрицательные и ноль)
            List<Integer> inputNumbers = Arrays.asList(15, -4, 28, 0, -12, 7, 42, -9, 3, -1);
            System.out.println("1. Исходные 10 чисел: " + inputNumbers);

            numberManager.writeNumbers(inputNumbers);
            System.out.println("2. Числа записаны в файл «" + numberManager.getFilePath() + "».");

            List<Integer> readNumbers = numberManager.readNumbers();
            System.out.println("3. Числа, считанные из файла: " + readNumbers);

            int positiveCount = numberManager.countPositive(readNumbers);
            System.out.println("4. Количество положительных чисел (> 0): " + positiveCount);

            System.out.println("\n--------------------------------------------------------------------------------");

            // -------------------------------------------------------------------------
            // ЗАДАНИЕ 3: Генерация 'f' со случайными числами, разделение на 'g' (< 100) и 'h' (>= 100)
            // -------------------------------------------------------------------------
            System.out.println("--- ЗАДАНИЕ 3: Разделение случайных чисел на файлы 'g' (< 100) и 'h' (>= 100) ---");
            NumberSplitter splitter = new NumberSplitter(
                    dataDir + "task3_f.txt",
                    dataDir + "task3_g.txt",
                    dataDir + "task3_h.txt"
            );

            List<Integer> randomNumbers = splitter.generateRandomFile(15, 10, 250);
            System.out.println("1. Сгенерировано 15 случайных чисел в файл 'f':");
            System.out.println("   " + randomNumbers);

            splitter.split();
            System.out.println("2. Выполнено разделение данных:");

            List<Integer> numbersG = splitter.readFile(splitter.getFileG());
            List<Integer> numbersH = splitter.readFile(splitter.getFileH());

            System.out.println("   -> Файл 'g' (числа < 100)  [всего: " + numbersG.size() + "]: " + numbersG);
            System.out.println("   -> Файл 'h' (числа >= 100) [всего: " + numbersH.size() + "]: " + numbersH);

            System.out.println("\n--------------------------------------------------------------------------------");

            // -------------------------------------------------------------------------
            // ЗАДАНИЕ 4: 15 вещественных значений концентрации вещества, средняя концентрация
            // -------------------------------------------------------------------------
            System.out.println("--- ЗАДАНИЕ 4: 15 вещественных концентраций, расчет средней ---");
            ConcentrationManager concManager = new ConcentrationManager(dataDir + "concentrations.txt");

            // 15 вещественных значений концентрации вещества (в мг/л или %)
            List<Double> concList = Arrays.asList(
                    12.45, 14.10, 11.80, 15.35, 13.90,
                    16.20, 12.05, 14.75, 15.00, 13.40,
                    11.95, 16.80, 14.25, 13.15, 15.65
            );
            System.out.println("1. Записываем 15 значений концентрации в файл: " + concManager.getFilePath());
            concManager.saveConcentrations(concList);

            List<Double> readConc = concManager.readConcentrations();
            System.out.println("2. Считанные значения концентрации:");
            for (int i = 0; i < readConc.size(); i++) {
                System.out.printf("   [%2d] %.4f%s", (i + 1), readConc.get(i), ((i + 1) % 5 == 0 ? "\n" : " | "));
            }

            double avgConc = concManager.calculateAverage(readConc);
            System.out.printf("3. Средняя концентрация вещества: %.4f%n", avgConc);

            System.out.println("\n--------------------------------------------------------------------------------");

            // -------------------------------------------------------------------------
            // ЗАДАНИЕ 5: 10 целых чисел в 'f', количество чисел, кратных 2 и 3 одновременно
            // -------------------------------------------------------------------------
            System.out.println("--- ЗАДАНИЕ 5: 10 целых чисел в 'f', подсчет кратных 2 и 3 (т.е. кратных 6) ---");
            DivisibilityAnalyzer divAnalyzer = new DivisibilityAnalyzer(dataDir + "task5_f.txt");

            // 10 целых чисел
            List<Integer> task5Numbers = Arrays.asList(12, 15, 18, 7, 24, 30, 25, 36, 14, 42);
            divAnalyzer.saveNumbers(task5Numbers);

            List<Integer> readTask5 = divAnalyzer.readNumbers();
            System.out.println("1. Числа из файла 'f': " + readTask5);

            List<Integer> divisibleNumbers = divAnalyzer.findDivisibleBy2And3(readTask5);
            System.out.println("2. Числа, кратные 2 и 3 одновременно: " + divisibleNumbers);
            System.out.println("3. Количество таких чисел: " + divisibleNumbers.size());

            System.out.println("\n================================================================================");
            System.out.println("              ВСЕ ЗАДАНИЯ ЛАБОРАТОРНОЙ РАБОТЫ № 14 ВЫПОЛНЕНЫ!");
            System.out.println("================================================================================");

        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

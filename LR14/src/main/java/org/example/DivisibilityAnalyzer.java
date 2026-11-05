package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DivisibilityAnalyzer {
    private String filePath;

    public DivisibilityAnalyzer(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Запись 10 целых чисел в файл 'f'.
     */
    public void saveNumbers(List<Integer> numbers) throws IOException {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int n : numbers) {
                writer.write(String.valueOf(n));
                writer.newLine();
            }
        }
    }

    /**
     * Считывание чисел из файла 'f'.
     */
    public List<Integer> readNumbers() throws IOException {
        List<Integer> numbers = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    numbers.add(Integer.parseInt(line));
                }
            }
        }
        return numbers;
    }

    /**
     * Поиск и подсчет чисел, кратных 2 и 3 одновременно (т.е. кратных 6).
     */
    public List<Integer> findDivisibleBy2And3(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int n : numbers) {
            if (n % 2 == 0 && n % 3 == 0) {
                result.add(n);
            }
        }
        return result;
    }
}

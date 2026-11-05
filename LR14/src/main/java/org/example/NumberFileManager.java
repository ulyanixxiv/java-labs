package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NumberFileManager {
    private String filePath;

    public NumberFileManager(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Запись 10 целых чисел в файл.
     */
    public void writeNumbers(List<Integer> numbers) throws IOException {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int num : numbers) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }
        }
    }

    /**
     * Чтение всех целых чисел из файла.
     */
    public List<Integer> readNumbers() throws IOException {
        List<Integer> result = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    result.add(Integer.parseInt(line));
                }
            }
        }
        return result;
    }

    /**
     * Подсчет количества положительных чисел (> 0).
     */
    public int countPositive(List<Integer> numbers) {
        int count = 0;
        for (int n : numbers) {
            if (n > 0) {
                count++;
            }
        }
        return count;
    }
}

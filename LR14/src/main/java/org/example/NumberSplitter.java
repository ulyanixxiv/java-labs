package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSplitter {
    private String fileF;
    private String fileG;
    private String fileH;

    public NumberSplitter(String fileF, String fileG, String fileH) {
        this.fileF = fileF;
        this.fileG = fileG;
        this.fileH = fileH;
    }

    public String getFileF() {
        return fileF;
    }

    public String getFileG() {
        return fileG;
    }

    public String getFileH() {
        return fileH;
    }

    /**
     * Создает исходный файл 'f' со случайными целыми числами.
     */
    public List<Integer> generateRandomFile(int count, int min, int max) throws IOException {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(max - min + 1) + min);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileF)))) {
            for (int num : numbers) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }
        }
        return numbers;
    }

    /**
     * Считывает числа из 'f' и разделяет:
     * - числа < 100 записываются в файл 'g';
     * - все остальные (>= 100) записываются в файл 'h'.
     */
    public void split() throws IOException {
        List<Integer> listG = new ArrayList<>();
        List<Integer> listH = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileF)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    int val = Integer.parseInt(line);
                    if (val < 100) {
                        listG.add(val);
                    } else {
                        listH.add(val);
                    }
                }
            }
        }

        writeToFile(fileG, listG);
        writeToFile(fileH, listH);
    }

    private void writeToFile(String path, List<Integer> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)))) {
            for (int v : data) {
                writer.write(String.valueOf(v));
                writer.newLine();
            }
        }
    }

    public List<Integer> readFile(String path) throws IOException {
        List<Integer> list = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            return list;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    list.add(Integer.parseInt(line));
                }
            }
        }
        return list;
    }
}

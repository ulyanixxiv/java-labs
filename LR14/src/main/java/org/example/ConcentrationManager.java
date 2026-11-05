package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcentrationManager {
    private String filePath;

    public ConcentrationManager(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Запись 15 вещественных значений концентрации вещества в файл.
     */
    public void saveConcentrations(List<Double> concentrations) throws IOException {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (double val : concentrations) {
                writer.write(String.format(java.util.Locale.US, "%.4f", val));
                writer.newLine();
            }
        }
    }

    /**
     * Считывание значений концентрации из файла.
     */
    public List<Double> readConcentrations() throws IOException {
        List<Double> result = new ArrayList<>();
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    result.add(Double.parseDouble(line.replace(',', '.')));
                }
            }
        }
        return result;
    }

    /**
     * Расчет средней концентрации вещества.
     */
    public double calculateAverage(List<Double> concentrations) {
        if (concentrations == null || concentrations.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (double val : concentrations) {
            sum += val;
        }
        return sum / concentrations.size();
    }
}

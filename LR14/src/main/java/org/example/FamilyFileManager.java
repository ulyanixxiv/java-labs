package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FamilyFileManager {
    private String filePath;
    private List<FamilyMember> members;

    public FamilyFileManager(String filePath) {
        this.filePath = filePath;
        this.members = new ArrayList<>();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void addMember(FamilyMember member) {
        members.add(member);
    }

    public List<FamilyMember> getMembers() {
        return members;
    }

    /**
     * Запись сведений о семье в текстовый файл с использованием FileWriter и BufferedWriter.
     */
    public void saveToFile() throws IOException {
        File file = new File(filePath);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("=== ИНФОРМАЦИЯ О СЕМЬЕ ===");
            writer.newLine();
            for (FamilyMember m : members) {
                writer.write(m.toString());
                writer.newLine();
            }
        }
    }

    /**
     * Вывод метаданных о созданном файле с помощью методов класса java.io.File.
     */
    public void printFileMetadata() {
        File file = new File(filePath);
        System.out.println("--- Метаданные файла (java.io.File): ---");
        System.out.println("  Имя файла:               " + file.getName());
        System.out.println("  Размер файла:            " + file.length() + " байт");
        System.out.println("  Абсолютный путь:         " + file.getAbsolutePath());
        System.out.println("  Существует ли файл:      " + (file.exists() ? "Да" : "Нет"));
        System.out.println("  Доступен для чтения:     " + (file.canRead() ? "Да" : "Нет"));
        System.out.println("  Доступен для записи:     " + (file.canWrite() ? "Да" : "Нет"));
        System.out.println("  Это обычный файл:        " + (file.isFile() ? "Да" : "Нет"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("  Дата последней правки:   " + sdf.format(new Date(file.lastModified())));
    }

    /**
     * Чтение и вывод содержимого файла с использованием BufferedReader и FileReader.
     */
    public void printFileContent() throws IOException {
        File file = new File(filePath);
        System.out.println("--- Содержимое файла «" + file.getName() + "»: ---");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        }
    }
}

package org.example;

public class Smartphone {
    private String model;
    private int memory;
    private int cameraMP;
private int kolvo;

public int getKolvo(){
    return kolvo;
}

public void setKolvo(int kolvo){
    this.kolvo = kolvo;
}

public Smartphone(String model, int memory, int cameraMP, int kolvo ){
    this(model, memory, cameraMP);
    this.kolvo = kolvo;
}

public void printInfo(){
    System.out.println(model);
    System.out.println(memory);
    System.out.println(cameraMP);
    System.out.println(totalPhones);
    System.out.println(totalMemory);
}













    private static int totalPhones = 0;
    private static long totalMemory = 0;

    public Smartphone(String model, int memory, int cameraMP) {
        this.model = model;
        this.memory = memory;
        this.cameraMP = cameraMP;

        totalPhones++;
        totalMemory += memory;
    }

    public String getModel() {

        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getMemory() {
        return memory;
    }
    public void setMemory(int memory) {
        totalMemory = totalMemory - this.memory + memory;
        this.memory = memory;
    }

    public int getCameraMP() {
        return cameraMP;
    }

    public void setCameraMP(int cameraMP) {
        this.cameraMP = cameraMP;
    }


    public static int getTotalPhones() {
        return totalPhones;
    }

    public static long getTotalMemory() {
        return totalMemory;
    }

    // метод который возвращает среднее количество памяти
    public static double getAverageMemory() {
        if (totalPhones == 0) {
            return 0.0;
        }
        return (double) totalMemory / totalPhones;
    }

    public void displayInfo() {
        System.out.printf("Смартфон: %-18s | Память: %4d ГБ | Камера: %3d Мп%n",
                model, memory, cameraMP);
    }


}

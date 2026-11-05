package org.example;

public class Goalkeeper extends Sportsman {
    private int saves;

    public Goalkeeper(String name, String team, int number, int saves) {
        super(name, team, number);
        this.saves = saves;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public void makeSave() {
        saves++;
        System.out.printf("Вратарь %s (%s) отразил удар! Всего сейвов: %d%n",
                getName(), getTeam(), saves);
    }

    @Override
    public String displayName(String name) {
        this.getName();
        return name;
    }

    @Override
    public String getPosition() {
        return "Вратарь";
    }

    @Override
    public void displayInfo() {
        System.out.printf("Спортсмен: %-15s | Команда: %-15s | Номер: %2d | Позиция: %-11s | Сейвов: %d%n",
                getName(), getTeam(), getNumber(), getPosition(), saves);
    }
}

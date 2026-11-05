package org.example;

public class Forward extends Sportsman {
    private int goals;

    public Forward(String name, String team, int number, int goals) {
        super(name, team, number);
        this.goals = goals;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void scoreGoal() {
        goals++;
        System.out.printf("Нападающий %s (%s) забил мяч! Всего голов: %d%n",
                getName(), getTeam(), goals);
    }

    @Override
    public String getPosition() {
        return "Нападающий";
    }

    @Override
    public void displayInfo() {
        System.out.printf("Спортсмен: %-15s | Команда: %-15s | Номер: %2d | Позиция: %-11s | Голов: %d%n",
                getName(), getTeam(), getNumber(), getPosition(), goals);
    }
}

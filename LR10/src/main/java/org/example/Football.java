package org.example;

public class Football implements Playable, Scorable {
    private String team1;
    private String team2;
    private int duration;
    private String score;

    public Football(String team1, String team2, int duration, String score) {
        this.team1 = team1;
        this.team2 = team2;
        this.duration = duration;
        this.score = score;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public void play() {
        System.out.printf("Матч по футболу между «%s» и «%s» начался (длительность: %d мин.)%n",
                team1, team2, duration);
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void score() {
        System.out.printf("Гол в футбольном матче «%s» — «%s»! Счет зафиксирован: %s%n",
                team1, team2, score);
    }

    @Override
    public String getScore() {
        return score;
    }

    public void displayInfo() {
        System.out.printf("Футбол: %-18s vs %-18s | Длительность: %2d мин. | Счет: %s%n",
                team1, team2, duration, score);
    }
}

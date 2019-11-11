package com.example.mingalgeleg_2;

public class CurrentGame {

    private static final CurrentGame ourInstance = new CurrentGame();

    private int winCounter;
    private int loseCounter;
    private int totalGames = winCounter + loseCounter;
    private String currWord;

    static CurrentGame getInstance() {
        return ourInstance;
    }

    private CurrentGame() {
    }

    public static CurrentGame getOurInstance() {
        return ourInstance;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }

    public int getLoseCounter() {
        return loseCounter;
    }

    public void setLoseCounter(int loseCounter) {
        this.loseCounter = loseCounter;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public String getCurrWord() {
        return currWord;
    }

    public void setCurrWord(String currWord) {
        this.currWord = currWord;
    }
}

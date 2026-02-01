package com.javarush.babkin;

public class PlayerStats {

    private long playerId;
    private int totalGames;
    private int wins;
    private int losses;

    public PlayerStats(long playerId) {
        this.playerId = playerId;
        this.totalGames = 0;
        this.wins = 0;
        this.losses = 0;
    }


    public long getPlayerId() { return playerId; }
    public int getTotalGames() { return totalGames; }
    public int getWins() { return wins; }
    public int getLosses() { return losses; }


    public void setTotalGames(int totalGames) { this.totalGames = totalGames; }
    public void setWins(int wins) { this.wins = wins; }
    public void setLosses(int losses) { this.losses = losses; }

    public double getWinRate() {
        if (totalGames == 0) return 0.0;
        return (double) wins / totalGames * 100;
    }

    public void incrementWin() {
        totalGames++;
        wins++;
    }

    public void incrementLoss() {
        totalGames++;
        losses++;
    }
}

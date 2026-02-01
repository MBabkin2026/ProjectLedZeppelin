package com.javarush.babkin;

public class UserDto {
    private long id;
    private String login;
    private int totalGames;
    private int wins;
    private int losses;
    private double winRate;

    public UserDto(long id, String login, int totalGames, int wins, int losses, double winRate) {
        this.id = id;
        this.login = login;
        this.totalGames = totalGames;
        this.wins = wins;
        this.losses = losses;
        this.winRate = winRate;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public double getWinRate() {
        return winRate;
    }
}
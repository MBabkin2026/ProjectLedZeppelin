package com.javarush;

import java.time.LocalDateTime;

public class GameRecord {
    private LocalDateTime timestamp;
    private int score;
    private boolean isWin;

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getScore() {
        return score;
    }

    public boolean isWin() {
        return isWin;
    }
}
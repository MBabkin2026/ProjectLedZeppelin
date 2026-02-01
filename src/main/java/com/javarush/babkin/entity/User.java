package com.javarush.babkin.entity;

import com.javarush.GameRecord;
import com.javarush.babkin.PlayerStats;
import com.javarush.babkin.QuestProgress;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String login;
    private String password;
    private Role role;
    private QuestProgress questProgress;

    private int wins;
    private int losses;

    private PlayerStats stats;
    private Integer totalGames;
    private List<GameRecord> gameHistory;

    public int getWins() {
        return (int) gameHistory.stream()
                .filter(GameRecord::isWin) // предполагаем поле isWin в GameRecord
                .count();
    }

    public int getLosses() {
        return (int) gameHistory.stream()
                .filter(game -> !game.isWin()) // не победа = поражение
                .count();
    }

    public String getImage() {return "image-" + id; }


}

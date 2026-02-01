package com.javarush.babkin.service;

import com.javarush.babkin.PlayerStats;
import com.javarush.babkin.entity.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatsService {
    private final Map<Long, PlayerStats> statsMap = new ConcurrentHashMap<>();

    private static final StatsService INSTANCE = new StatsService();

    public PlayerStats getStatsForUser(User user) {
        return statsMap.computeIfAbsent(user.getId(), id -> new PlayerStats(id));
    }

    public void updateUserStats(User user, boolean isWin) {
        PlayerStats stats = getStatsForUser(user);
        if (isWin) {
            stats.incrementWin();
        } else {
            stats.incrementLoss();
        }
        user.setStats(stats);
    }


    public void populateStatsForUsers(List<User> users) {
        for (User user : users) {
            user.setStats(getStatsForUser(user));
        }
    }

    public static StatsService getInstance() {
        return INSTANCE;
    }

    public PlayerStats getStats(long playerId) {
        return statsMap.computeIfAbsent(playerId, id -> new PlayerStats(id));
    }


    public void recordWin(long playerId) {
        PlayerStats stats = getStats(playerId);
        stats.incrementWin();
    }


    public void recordLoss(long playerId) {
        PlayerStats stats = getStats(playerId);
        stats.incrementLoss();
    }


    public void updateStats(long playerId, int totalGames, int wins, int losses) {
        PlayerStats stats = getStats(playerId);
        stats.setTotalGames(totalGames);
        stats.setWins(wins);
        stats.setLosses(losses);
    }


    public void resetStats(long playerId) {
        statsMap.remove(playerId);
    }


    public Map<Long, PlayerStats> getAllStats() {
        return new ConcurrentHashMap<>(statsMap);
    }
}

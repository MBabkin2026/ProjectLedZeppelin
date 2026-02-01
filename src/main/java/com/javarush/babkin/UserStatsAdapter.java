package com.javarush.babkin;

import com.javarush.babkin.entity.User;
import com.javarush.babkin.service.StatsService;
import com.javarush.babkin.service.UserService;

public class UserStatsAdapter {

    private final UserService userService;
    private final StatsService statsService;

    public UserStatsAdapter(UserService userService, StatsService statsService) {
        this.userService = userService;
        this.statsService = statsService;
    }

    public UserDto getUserWithStats(long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return null;
        }

        PlayerStats stats = statsService.getStatsForUser(user);

        return new UserDto(
                user.getId(),
                user.getLogin(),
                stats.getTotalGames(),
                stats.getWins(),
                stats.getLosses(),
                stats.getWinRate()
        );
    }
}

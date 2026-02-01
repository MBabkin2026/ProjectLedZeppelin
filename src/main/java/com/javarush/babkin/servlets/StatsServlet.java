package com.javarush.babkin.servlets;

import com.javarush.babkin.service.StatsService;
import com.javarush.babkin.UserDto;
import com.javarush.babkin.UserStatsAdapter;
import com.javarush.babkin.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/stats")
public class StatsServlet extends HttpServlet {

    private final UserService userService = UserService.USER_SERVICE;
    private final StatsService statsService = new StatsService();


    private final UserStatsAdapter userStatsAdapter =
            new UserStatsAdapter(userService, statsService);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long userId = Long.parseLong(request.getParameter("userId"));

        UserDto user = userStatsAdapter.getUserWithStats(userId);

        if (user == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Пользователь не найден");
            return;
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("/user-stats.jsp").forward(request, response);
    }
}

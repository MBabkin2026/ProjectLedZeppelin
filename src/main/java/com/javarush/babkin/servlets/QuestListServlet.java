package com.javarush.babkin.servlets;

import com.javarush.babkin.entity.Quest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/quest-list")
public class QuestListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userIdParam = req.getParameter("userId");
        if (userIdParam == null || userIdParam.trim().isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "userId is required");
            return;
        }
        Long userId = Long.parseLong(userIdParam);

        List<Quest> quests = Arrays.asList(
                new Quest(1L, "UFO Quest", "Спасти корабль от пришельцев"),
                new Quest(2L, "Тайный код", "Расшифровать послание"),
                new Quest(3L, "Побег из лаборатории", "Найти выход")
        );

        req.setAttribute("userId", userId);
        req.setAttribute("quests", quests);

        req.getRequestDispatcher("/WEB-INF/quest-list.jsp")
                .forward(req, resp);
    }
}

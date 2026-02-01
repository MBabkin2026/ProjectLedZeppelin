package com.javarush.babkin.servlets;

import com.javarush.babkin.QuestProgress;
import com.javarush.babkin.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("userId"));
        QuestProgress progress = userService.getQuestProgress(userId);

        req.setAttribute("progress", progress);
        req.setAttribute("userId", userId); // передаём ID в JSP
        req.getRequestDispatcher("/WEB-INF/quest.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long userId = Long.valueOf(req.getParameter("userId"));
        String action = req.getParameter("action");

        QuestProgress progress = userService.getQuestProgress(userId);


        switch (progress.getStep()) {
            case "start":
                if ("accept".equals(action)) progress.setStep("accept");
                else if ("decline".equals(action)) {
                    progress.setStep("decline");
                    progress.setFinished(true);
                }
                break;
        }

        userService.updateQuestProgress(userId, progress);
        resp.sendRedirect(req.getContextPath() + "/quest?userId=" + userId);
    }
}
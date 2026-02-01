package com.javarush.babkin.servlets;

import com.javarush.babkin.QuestProgress;
import com.javarush.babkin.entity.Role;
import com.javarush.babkin.entity.User;
import com.javarush.babkin.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(value = {"", "/user-list"})
public class UserListServlet extends HttpServlet {
    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("users", userService.getAll());
        req.getRequestDispatcher("/WEB-INF/user-list.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if ("create".equals(req.getParameter("action"))) {
            User user = new User();
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            user.setRole(Role.valueOf(req.getParameter("role")));
            user.setQuestProgress(new QuestProgress());
            userService.create(user);
        }
        resp.sendRedirect(req.getContextPath() + "/user-list");
    }
}

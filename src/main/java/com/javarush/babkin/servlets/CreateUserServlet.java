package com.javarush.babkin.servlets;

import com.javarush.babkin.entity.Role;
import com.javarush.babkin.entity.User;
import com.javarush.babkin.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;


@WebServlet("/create-user")
public class CreateUserServlet extends HttpServlet {

    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/create-user.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("id");


        boolean isRegistration = (parameter == null || parameter.trim().isEmpty());


        User user = new User();
        user.setId(isRegistration ? null : Long.valueOf(parameter));
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        user.setRole(Role.valueOf(req.getParameter("role")));

        if (req.getParameter("create") != null) {
            userService.create(user);
        }

        if (isRegistration) {
            resp.sendRedirect(req.getContextPath() + "/user-list?userId=" + user.getId());
        } else {
            resp.sendRedirect(req.getContextPath() + "/edit-user?id=" + user.getId());
        }
    }

}


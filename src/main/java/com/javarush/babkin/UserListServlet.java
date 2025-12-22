package com.javarush.babkin;

import com.javarush.babkin.entity.User;
import com.javarush.babkin.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Collection;

@WebServlet(value = {"","/user-list"})
public class UserListServlet extends HttpServlet {

    private final UserService userService = UserService.USER_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<User> users = userService.getAll();

        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/user-list.jsp").forward(req, resp);

    }
}

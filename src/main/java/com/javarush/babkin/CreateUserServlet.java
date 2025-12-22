package com.javarush.babkin;

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
        User user = User.builder()
                .id(parameter != null ? Long.valueOf(parameter) : null)
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .role(Role.valueOf(req.getParameter("role")))
                .build();
        if (req.getParameter("create")!= null) {
            userService.create(user);
        }

//        resp.sendRedirect(req.getContextPath() + "/WEB-INF/create-user?id=" + user.getId());
//        resp.sendRedirect(req.getContextPath() + "create-user?id=" + user.getId());
        resp.sendRedirect(req.getContextPath() + "/edit-user?id=" + user.getId());

    }
}

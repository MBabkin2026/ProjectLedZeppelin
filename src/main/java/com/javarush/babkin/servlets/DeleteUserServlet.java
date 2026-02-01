package com.javarush.babkin.servlets;

import com.javarush.babkin.entity.User;
import com.javarush.babkin.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/delete-user")
public class DeleteUserServlet extends HttpServlet {

    private final UserService userService = UserService.USER_SERVICE; // Ваш экземпляр сервиса

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userIdParam = request.getParameter("userId");
        if (userIdParam == null || userIdParam.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID пользователя не указан");
            return;
        }

        long userId = Long.parseLong(request.getParameter("userId"));

        Optional<User> optionalUser = userService.getById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userService.delete(user);
            response.sendRedirect(request.getContextPath() + "/user-list");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Пользователь не найден");
        }

    }
}


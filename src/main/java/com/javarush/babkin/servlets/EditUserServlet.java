package com.javarush.babkin.servlets;

import com.javarush.babkin.entity.Role;
import com.javarush.babkin.entity.User;
import com.javarush.babkin.service.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/edit-user", loadOnStartup = 1)
public class EditUserServlet extends HttpServlet {

    private final UserService userService = UserService.USER_SERVICE;

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            req.setAttribute("error", "ID пользователя не указан.");
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
            return;
        }

        try {
            long userId = Long.parseLong(idParam);
            Optional<User> user = userService.getById(userId);

            if (user.isPresent()) {
                req.setAttribute("user", user.get());
                req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Пользователь не найден.");
                req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Некорректный ID: " + idParam);
            req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String roleParam = req.getParameter("role");

        if (idParam == null || idParam.trim().isEmpty() ||
                login == null || login.trim().isEmpty() ||
                password == null || password.trim().isEmpty() ||
                roleParam == null || roleParam.trim().isEmpty()) {

            req.setAttribute("error", "Все поля обязательны для заполнения.");
            req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);
            return;
        }

        try {
            long userId = Long.parseLong(idParam);

            Role role;
            try {
                role = Role.valueOf(roleParam.toUpperCase());
            } catch (IllegalArgumentException e) {
                req.setAttribute("error", "Недопустимая роль: " + roleParam);
                req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);
                return;
            }

            User user = User.builder()
                    .id(userId)
                    .login(login)
                    .password(password)
                    .role(role)
                    .build();

            if ("true".equals(req.getParameter("update"))) {
                userService.update(user);
                resp.sendRedirect(req.getContextPath() + "/user-list");
            } else if ("true".equals(req.getParameter("delete"))) {
                userService.delete(user);
                resp.sendRedirect(req.getContextPath() + "/user-list");
            } else {
                req.setAttribute("error", "Неизвестное действие.");
                req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);
            }

        } catch (NumberFormatException e) {
            req.setAttribute("error", "Некорректный ID: " + idParam);
            req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Ошибка при обработке запроса: " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);
        }
    }
}
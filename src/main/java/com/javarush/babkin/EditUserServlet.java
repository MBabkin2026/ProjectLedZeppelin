package com.javarush.babkin;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            long userId = Long.parseLong(id);
            Optional<User> user = userService.getById(userId);
            user.ifPresent(value -> req.setAttribute("user", value));
//            if (user.isPresent()) {
//                req.setAttribute("user", user);
//            }
        }
        req.getRequestDispatcher("/WEB-INF/edit-user.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("id");
        User user = User.builder()
                .id(parameter != null ? Long.parseLong(parameter) : null)
                .login(req.getParameter("login"))
                .password(req.getParameter("password"))
                .role(Role.valueOf(req.getParameter("role")))
                .build();


//        if (req.getParameter("create")!= null) {
//            userService.create(user);
//        } else
            if (req.getParameter("update") != null) {
            user.setId(Long.valueOf(req.getParameter("id")));
            userService.update(user);
        } else if (req.getParameter("delete") != null) {
            user.setId(Long.valueOf(req.getParameter("id")));
            userService.delete(user);
        }

//        resp.sendRedirect(req.getContextPath() + "/edit-user?id=" + req.getParameter("id"));
        resp.sendRedirect(req.getContextPath() + "/edit-user?id=" + user.getId());
    }
}

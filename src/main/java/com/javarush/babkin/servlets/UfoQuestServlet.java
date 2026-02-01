package com.javarush.babkin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ufo-quest")
public class UfoQuestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userIdParam = request.getParameter("userId");

        if (userIdParam == null || userIdParam.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/user-list");
            return;
        }

        request.setAttribute("userId", userIdParam);
        request.getRequestDispatcher("/WEB-INF/ufo-quest.jsp")
                .forward(request, response);

    }

}
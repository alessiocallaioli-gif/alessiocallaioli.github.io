package com.example.dashboard.servlet;

import com.example.dashboard.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("user") != null){
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
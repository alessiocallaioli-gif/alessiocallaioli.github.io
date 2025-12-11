package com.example.dashboard.servlet;

import com.example.dashboard.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/dashboard_db?useSSL=false&serverTimezone=UTC";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "root";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("dashboard");
            } else {
                response.sendRedirect("login.jsp?error=true");
            }

            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e){
            throw new ServletException(e);
        }
    }
}
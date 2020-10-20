package servlets;

import enums.Role;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminLogin", urlPatterns = "/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    private static String adminLogin = "admin";
    private static String adminPassword = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(adminLogin.equals(login) && adminPassword.equals(password)){
            User admin = new User(login, password, Role.ADMIN);
            request.getServletContext().setAttribute("role", "ADMIN");
            RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("/dashboard");
            dashboardDispatcher.forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/html/loginFailed.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

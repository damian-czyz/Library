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

@WebServlet(name = "UserLogin", urlPatterns = "/userLogin")
public class UserLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if(User.checkUser(User.init(),login,password)){
            User newUser = new User(login,password);
            request.getServletContext().setAttribute("role", "USER");
            RequestDispatcher dashboardDispatcher = request.getRequestDispatcher("/dashboard");
            dashboardDispatcher.forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/html/loginFailed.html").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

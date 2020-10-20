package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");

        if("admin".equals(login)){
            RequestDispatcher adminDispatcher = request.getRequestDispatcher("/adminLogin");
            adminDispatcher.forward(request, response);
        }else{
            RequestDispatcher userDispatcher = request.getRequestDispatcher("/userLogin");
            userDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher loginPageDispatcher = request.getRequestDispatcher("WEB-INF/html/login.html");
        loginPageDispatcher.forward(request, response);
    }

}

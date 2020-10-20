package servlets;

import models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@WebServlet(name = "Dashboard", urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        List<Book> books = (List<Book>) request.getServletContext().getAttribute("books");
        ListIterator<Book> it = books.listIterator();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>Books</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<div>DASHBOARD</div>");

            if(!books.isEmpty())
                while(it.hasNext())
                    writer.println("</br></br>Book:</br>" + books);

            writer.println("</body>");
            writer.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

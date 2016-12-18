package ru.itis.inform.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Nurami on 20.11.2016.
 */
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("login")!=null){
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            resp.sendRedirect("/index");
        }
        else {
            resp.sendRedirect("/signin");
        }
    }
}

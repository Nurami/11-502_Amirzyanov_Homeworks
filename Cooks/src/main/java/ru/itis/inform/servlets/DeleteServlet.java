package ru.itis.inform.servlets;


import ru.itis.inform.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nurami on 24.11.2016.
 */
public class DeleteServlet extends HttpServlet {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ((req.getSession().getAttribute("login")!=null)&&(req.getSession().getAttribute("role").equals("admin"))){
            String name = req.getParameter("select1");
            String flag = serviceFactory.getDishService().deleteDish(name);
            req.setAttribute("flag", flag);
            req.getRequestDispatcher("Message.jsp").include(req, resp);
        }
        else {
            resp.sendRedirect("/signin");
        }
    }
}

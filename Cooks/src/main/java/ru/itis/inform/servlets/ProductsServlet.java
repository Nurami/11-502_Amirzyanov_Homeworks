package ru.itis.inform.servlets;

import ru.itis.inform.factory.ServiceFactory;
import ru.itis.inform.utils.Number;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nurami on 18.12.2016.
 */
public class ProductsServlet extends HttpServlet {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login")!=null){
            List list = serviceFactory.getProductService().getAll();
            req.setAttribute("products", list);
            req.getRequestDispatcher("Products.jsp").forward(req, resp);
        }
        else resp.sendRedirect("/signin");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] param = req.getParameterValues("input");
        String[] name = req.getParameterValues("name");
        String flag = "Not positive or empty field";
        for (int i=0; i<param.length; i++) {
            if (Number.check(param[i])) {
                int amount = Integer.parseInt(param[i]);
                flag = serviceFactory.getProductService().changeAmount(name[i], amount);
            }
            else {
                flag = "Not positive or empty field";
                break;
            }
        }
        req.setAttribute("flag", flag);
        req.getRequestDispatcher("Message.jsp").forward(req, resp);
    }
}

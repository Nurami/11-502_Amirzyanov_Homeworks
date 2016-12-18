package ru.itis.inform.servlets;

import ru.itis.inform.utils.CheckStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nurami on 18.12.2016.
 */
public class ServiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] param = req.getParameterValues("ch1");
        String[] param1 = req.getParameterValues("ch2");
        int[] amounts = new int[param.length];
        for (int i=0; i<param.length; i++){
            amounts[i]=Integer.parseInt(param1[i]);
        }
        String[] result = CheckStorage.check(param, amounts);
        req.setAttribute("result", result);
        req.getRequestDispatcher("Message.jsp").include(req, resp);
    }
}

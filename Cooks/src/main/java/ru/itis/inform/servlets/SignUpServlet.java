package ru.itis.inform.servlets;

import ru.itis.inform.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nurami on 19.11.2016.
 */
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/SignUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        resp.setCharacterEncoding("UTF-8");
        String confirmPassword = req.getParameter("confirm_password");
        if (!login.equals("")&&!password.equals("")&&!confirmPassword.equals("")){
            if (password.equals(confirmPassword)) {
                if (serviceFactory.getUserService().checkLogin(login)) {
                    serviceFactory.getUserService().saveUser(login, password);
                    resp.sendRedirect("/signin");
                }
                else {
                    String errorOfLogin = "Login is already in use";
                    req.setAttribute("errorofregistration", errorOfLogin);
                    req.getRequestDispatcher("/SignUp.jsp").include(req, resp);
                }
            }
            else {
                String errorOfpassword = "Passwords not equal";
                req.setAttribute("errorofregistration", errorOfpassword);
                req.getRequestDispatcher("/SignUp.jsp").include(req, resp);
            }
        }
        else{
            String errorOfEmpty = "Please, write in empty fields";
            req.setAttribute("errorofregistration", errorOfEmpty);
            req.getRequestDispatcher("/SignUp.jsp").include(req, resp);
        }
    }
}

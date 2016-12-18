package ru.itis.inform.servlets;


import ru.itis.inform.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Nurami on 19.11.2016.
 */
public class SignInServlet extends HttpServlet {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean check = false;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("current_user")) {
                if (serviceFactory.getTokenService().getIdOfToken(cookie.getValue()) != 0) {
                    int userId = serviceFactory.getTokenService().getIdOfToken(cookie.getValue());
                    HttpSession session = req.getSession();
                    session.setAttribute("login", serviceFactory.getUserService().getUser(userId).getLogin());
                    session.setAttribute("role", serviceFactory.getUserService().getUser(userId).getRole());
                    check = true;
                    resp.sendRedirect("/index");
                }
            }
        }
        if(!check) {
            req.getRequestDispatcher("/SignIn.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String savingCookie = req.getParameter("savingcookie");
        if (serviceFactory.getUserService().checkLogin(login)||(!serviceFactory.getUserService().checkPassword(login, password))){
            String errorOfLogin = "Login or password not correct,maybe you aren't registered";
            req.setAttribute("errorofsignin", errorOfLogin);
            req.getRequestDispatcher("/SignIn.jsp").include(req, resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setAttribute("password", password);
            session.setAttribute("role", serviceFactory.getUserService().getUser(login).getRole());
            if ((savingCookie!=null) && (savingCookie.equals("remember"))){
                String token = serviceFactory.getTokenService().generateToken();
                serviceFactory.getTokenService().saveToken(serviceFactory.getUserService().getUser(login).getId(), token);
                Cookie cookie = new Cookie("current_user", token);
                cookie.setMaxAge(180 * 24 * 60 * 60);
                resp.addCookie(cookie);
            }
            resp.sendRedirect("/index");
        }


    }
}

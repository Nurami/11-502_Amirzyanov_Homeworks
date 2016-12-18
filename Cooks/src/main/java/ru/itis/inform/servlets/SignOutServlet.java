package ru.itis.inform.servlets;



import ru.itis.inform.factory.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nurami on 20.11.2016.
 */
public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("current_user")) {
                if (ServiceFactory.getInstance().getTokenService().getIdOfToken(cookie.getValue())!=0) {
                    ServiceFactory.getInstance().getTokenService().deleteToken(cookie.getValue());
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
        }
        req.getSession().invalidate();
        resp.sendRedirect("/signin");
        return;
        }
}

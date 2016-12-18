package ru.itis.inform.servlets;


import ru.itis.inform.factory.ServiceFactory;
import ru.itis.inform.models.Dish;
import ru.itis.inform.models.Ingredient;
import ru.itis.inform.models.Product;
import ru.itis.inform.models.Recipe;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 06.11.2016.
 */
public class DishesServlet extends HttpServlet{
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login")!=null) {


            List list4 = serviceFactory.getDishService().getAll();
            req.setAttribute("dishes", list4);

            req.getRequestDispatcher("Dishes.jsp").forward(req,resp);
        }
        else {
            resp.sendRedirect("/signin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login")!=null) {
            String param = req.getParameter("select1");
            Dish dish = serviceFactory.getDishService().getByName(param);
            List list4 = serviceFactory.getDishService().getAll();
            req.setAttribute("dishes", list4);
            if (dish != null) {
                String recipe = serviceFactory.getDishService().getRecipe();
                List<Ingredient> list = serviceFactory.getIngredientService().getAll(dish.getIngredientId());
                List<Product> list1 = new ArrayList<Product>();
                List list2 = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    Product product = serviceFactory.getProductService().getById(list.get(i).getProductId());
                    list1.add(product);
                    list2.add(list.get(i).getAmount());
                }
                req.setAttribute("dish", dish.getName());
                req.setAttribute("recipe", recipe);
                req.setAttribute("products", list1);
                req.setAttribute("amounts", list2);
            }
            req.getRequestDispatcher("Dishes.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/signin");
        }
    }
}

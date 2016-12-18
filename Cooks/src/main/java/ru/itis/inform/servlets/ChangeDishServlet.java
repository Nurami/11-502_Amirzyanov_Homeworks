package ru.itis.inform.servlets;

import ru.itis.inform.factory.ServiceFactory;
import ru.itis.inform.models.Dish;
import ru.itis.inform.models.Ingredient;
import ru.itis.inform.models.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 17.12.2016.
 */
public class ChangeDishServlet extends HttpServlet {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("select1");
        Dish dish = serviceFactory.getDishService().getByName(param);
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

        req.getRequestDispatcher("ChangeDish.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dishOld = req.getParameter("dish");
        String dishNew = req.getParameter("dish1");
        String recipe = req.getParameter("recipe");
        String product = req.getParameter("product");
        String amount = req.getParameter("amount");
        String flag = " ";
        int intAmount = -1;
        Dish dish =serviceFactory.getDishService().getByName(dishOld);
        flag = serviceFactory.getDishService().changeRecipe(recipe);
        if (flag.equals("Success")) {
            if (amount.matches("[0-9]+") && (!amount.equals("0"))) {
                intAmount = Integer.parseInt(amount);
            } else {
                flag = "Amount must be pozitive";
            }
        }
        if (flag.equals("Success")) {
            flag = serviceFactory.getIngredientService().changeAmount(dish.getIngredientId(), serviceFactory.getProductService().getByName(product).getId(), intAmount);
        }
        if (flag.equals("Success")) {
            flag =serviceFactory.getDishService().changeDish(dishOld, dishNew);
        }
        req.setAttribute("flag", flag);
        req.getRequestDispatcher("Message.jsp").include(req, resp);
    }
}

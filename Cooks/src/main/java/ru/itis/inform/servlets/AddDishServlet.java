package ru.itis.inform.servlets;

import ru.itis.inform.factory.ServiceFactory;
import ru.itis.inform.models.Dish;
import ru.itis.inform.models.Ingredient;
import ru.itis.inform.utils.Mass;
import ru.itis.inform.utils.Number;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nurami on 24.11.2016.
 */
public class AddDishServlet extends HttpServlet {
    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("login")!=null){

            List list = serviceFactory.getProductService().getAll();
            req.setAttribute("products", list);
            req.getRequestDispatcher("AddDish.jsp").forward(req, resp);
        }
        else {
            resp.sendRedirect("/signin");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String name = "Please, write dish name, recipe, products with amounts";
        String dish = req.getParameter("input2");
        String recipe = req.getParameter("textarea2");
        String pr1 = req.getParameter("s1");
        String am1 = req.getParameter("i1");
        String pr2 = req.getParameter("s2");
        String am2 = req.getParameter("i2");
        String pr3 = req.getParameter("s3");
        String am3 = req.getParameter("i3");
        String pr4 = req.getParameter("s4");
        String am4 = req.getParameter("i4");
        String pr5 = req.getParameter("s5");
        String am5 = req.getParameter("i5");
        String pr6 = req.getParameter("s6");
        String am6 = req.getParameter("i6");
        String pr7 = req.getParameter("s7");
        String am7 = req.getParameter("i7");
        String[] mas = {pr1, pr2, pr3, pr4, pr5, pr6, pr7};
        String[] amounts ={am1, am2, am3, am4, am5, am6, am7};
        int mass[] = new int[6];
        int size = 0;

        boolean k = true;
        for (int i=0; i<7; i++){
            if ((Number.check(amounts[i]))&& (Mass.check(mas, mas[i], i))){
                if (!mas[i].equals("Choose Product")){
                    size++;
                    mass[i]=Integer.parseInt(amounts[i]);
                }
                else {
                    break;
                }
            }
            else {
                if (mas[i].equals("Choose Product")){
                    break;
                }
                else{
                    k=false;
                    name="Number of products must be positive or product already choose";
                    break;
                }

            }

        }
        if ((k)&&(size!=0)){
            String ch = serviceFactory.getDishService().saveDish(new Dish(dish));
            if (ch.equals("Success")){
                name = ch;
                Dish dish1 = serviceFactory.getDishService().getByName(dish);
                String s =serviceFactory.getDishService().saveRecipe(recipe);
                if (s.equals("Success")) {
                    for (int i = 0; i < size; i++) {
                        Ingredient ingredient = new Ingredient(dish1.getIngredientId(), serviceFactory.getProductService().getByName(mas[i]).getId(), mass[i]);
                        serviceFactory.getIngredientService().save(ingredient);
                    }
                }
                else name=s;
            }
            else name= ch;
        }

        req.setAttribute("flag", name);

        req.getRequestDispatcher("Message.jsp").forward(req, resp);
    }
}

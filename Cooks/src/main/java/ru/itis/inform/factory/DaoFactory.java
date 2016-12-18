package ru.itis.inform.factory;

import ru.itis.inform.dao.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Nurami on 13.12.2016.
 */
public class DaoFactory {
    private static DaoFactory instance;
    private Properties properties;

    private DishDao dishDao;
    private RecipeDao recipeDao;
    private DishOfOrderDao dishOfOrderDao;
    private IngredientDao ingredientDao;
    private OrderDao orderDao;
    private ProductDao productDao;
    private TokenDao tokenDao;
    private UserDao userDao;

    private DaoFactory() {
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\Nurami\\IdeaProjects\\Cooks\\src\\main\\resources\\dao.properties"));

            String dishClass = properties.getProperty("dish.class");
            String recipeClass = properties.getProperty("recipe.class");
            String dishOfOrderClass = properties.getProperty("dishOfOrder.class");
            String ingredientClass = properties.getProperty("ingredient.class");
            String orderClass = properties.getProperty("order.class");
            String productClass = properties.getProperty("product.class");
            String tokenClass = properties.getProperty("token.class");
            String userClass = properties.getProperty("user.class");

            this.dishDao = (DishDao) Class.forName(dishClass).newInstance();
            this.recipeDao = (RecipeDao) Class.forName(recipeClass).newInstance();
            this.dishOfOrderDao = (DishOfOrderDao) Class.forName(dishOfOrderClass).newInstance();
            this.ingredientDao = (IngredientDao) Class.forName(ingredientClass).newInstance();
            this.orderDao = (OrderDao) Class.forName(orderClass).newInstance();
            this.productDao = (ProductDao) Class.forName(productClass).newInstance();
            this.tokenDao = (TokenDao) Class.forName(tokenClass).newInstance();
            this.userDao = (UserDao) Class.forName(userClass).newInstance();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException();
        }
    }

    static {
        instance = new DaoFactory();
    }

    public static DaoFactory getInstance(){
        return instance;
    }

    public DishDao getDishDao() {
        return dishDao;
    }

    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public DishOfOrderDao getDishOfOrderDao() {
        return dishOfOrderDao;
    }

    public IngredientDao getIngredientDao() {
        return ingredientDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public TokenDao getTokenDao() {
        return tokenDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}

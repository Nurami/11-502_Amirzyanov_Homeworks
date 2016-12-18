package ru.itis.inform.factory;

import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.UserService;
import ru.itis.inform.services.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Nurami on 27.11.2016.
 */
public class ServiceFactory {
    private static ServiceFactory instance;
    private Properties properties;

    private DishService dishService;
    private DishOfOrderService dishOfOrderService;
    private IngredientService ingredientService;
    private OrderService orderService;
    private ProductService productService;
    private TokenService tokenService;
    private UserService userService;

    ServiceFactory(){
        try {
            properties = new Properties();
            properties.load(
                    new FileInputStream("C:\\Users\\Nurami\\IdeaProjects\\Cooks\\src\\main\\resources\\service.properties"));


            String dishClass = properties.getProperty("dish.class");
            String dishOfOrderClass = properties.getProperty("dishOfOrder.class");
            String ingredientClass = properties.getProperty("ingredient.class");
            String orderClass = properties.getProperty("order.class");
            String productClass = properties.getProperty("product.class");
            String tokenClass = properties.getProperty("token.class");
            String userClass = properties.getProperty("user.class");

            this.dishService = (DishService) Class.forName(dishClass).newInstance();
            this.dishOfOrderService = (DishOfOrderService) Class.forName(dishOfOrderClass).newInstance();
            this.ingredientService = (IngredientService) Class.forName(ingredientClass).newInstance();
            this.orderService = (OrderService) Class.forName(orderClass).newInstance();
            this.productService = (ProductService) Class.forName(productClass).newInstance();
            this.tokenService = (TokenService) Class.forName(tokenClass).newInstance();
            this.userService = (UserService) Class.forName(userClass).newInstance();

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

    static  {
        instance = new ServiceFactory();
    }

    public DishService getDishService() {
        return dishService;
    }

    public DishOfOrderService getDishOfOrderService() {
        return dishOfOrderService;
    }

    public IngredientService getIngredientService() {
        return ingredientService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public ProductService getProductService() {
        return productService;
    }

    public TokenService getTokenService() {
        return tokenService;
    }

    public UserService getUserService() {
        return userService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}


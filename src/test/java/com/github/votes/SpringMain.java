package com.github.votes;

import com.github.votes.model.*;
import com.github.votes.web.*;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Arrays;

import static com.github.votes.repository.mock_data.DishTestData.*;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_ID_1;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_ID_3;
import static com.github.votes.repository.mock_data.UserTestData.ADMIN_ID_1;
import static com.github.votes.repository.mock_data.UserTestData.USER_ID_1;

public class SpringMain {
    private static final String UNDER_LINE = "==========================================================================";

    public static void main(String[] args) {

        try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();
            System.out.println("\nBean definition names: " +
                    "\n=======================");
            Arrays.stream(appCtx.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(UNDER_LINE);

            // Test dish rest controller
            DishRestController dishController = appCtx.getBean(DishRestController.class);
            Dish dish_1 = dishController.get(DISH_ID_01);
            Dish dish_2 = dishController.get(DISH_ID_02);
            Dish dish_4 = dishController.get(DISH_ID_04);
            System.out.println(dish_1);
            System.out.println(dishController.getAll());
            System.out.println(UNDER_LINE);

            // Test restaurant rest controller
            RestaurantRestController restaurantController = appCtx.getBean(RestaurantRestController.class);
            Restaurant restaurant_1 = restaurantController.get(RESTAURANT_ID_1);
            Restaurant restaurant_3 = restaurantController.get(RESTAURANT_ID_3);
            System.out.println(restaurant_1);
            System.out.println(restaurantController.getAll());
            System.out.println(UNDER_LINE);

            // Test user rest controller
            UserRestController userController = appCtx.getBean(UserRestController.class);
            User admin_1 = userController.get(ADMIN_ID_1);
            User user_1 = userController.get(USER_ID_1);
            System.out.println(admin_1);
            System.out.println(user_1);
            System.out.println(userController.getAll());
            System.out.println(UNDER_LINE);

            // Test MenuItem rest controller
            MenuItemRestController menuItemRestController = appCtx.getBean(MenuItemRestController.class);
            // add data
            MenuItem menuItem_1 = new MenuItem(null, dish_1, restaurant_1, LocalDateTime.now());
            MenuItem menuItem_2 = new MenuItem(null, dish_2, restaurant_1, LocalDateTime.now());
            MenuItem menuItem_3 = new MenuItem(null, dish_1, restaurant_3, LocalDateTime.now());
            MenuItem menuItem_4 = new MenuItem(null, dish_4, restaurant_3, LocalDateTime.now());
            // test added data
            menuItemRestController.create(menuItem_1);
            menuItemRestController.create(menuItem_2);
            menuItemRestController.create(menuItem_3);
            menuItemRestController.create(menuItem_4);
            System.out.println(menuItemRestController.get(1));
            System.out.println(menuItemRestController.getAll());
            System.out.println(menuItemRestController.getByRestaurant(RESTAURANT_ID_3));
            // test update
            MenuItem menuItem_2_updated = new MenuItem(2, dish_2, restaurant_3, LocalDateTime.now());
            menuItemRestController.update(menuItem_2_updated, 2);
            System.out.println(menuItemRestController.getAll());
            // test delete
            menuItemRestController.delete(3);
//            System.out.println(menuItemRestController.get(3));
            System.out.println(UNDER_LINE);

            // Test Vote rest controller
            VoteRestController voteRestController = appCtx.getBean(VoteRestController.class);
            Vote vote = new Vote(null, restaurant_3, user_1, LocalDateTime.now());
            System.out.println(voteRestController.take(vote));
            System.out.println(voteRestController.get());
            voteRestController.delete();
//            System.out.println(voteRestController.get(1));
            System.out.println(UNDER_LINE);
        }
    }
}

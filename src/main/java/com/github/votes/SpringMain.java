package com.github.votes;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring-app.xml")) {
            System.out.println("\nBean definition names: " +
                               "\n=======================");
            Arrays.stream(appCtx.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("=======================\n");
//            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
//            adminUserController.create(new User(null, "userName", "email", "password", Role.ROLE_ADMIN));
//            System.out.println();

//            MealRestController mealController = appCtx.getBean(MealRestController.class);
//            List<MealWithExceed> filteredMealsWithExceeded =
//                    mealController.getBetween(
//                            LocalDate.of(2015, Month.MAY, 30), LocalTime.of(7, 0),
//                            LocalDate.of(2015, Month.MAY, 31), LocalTime.of(11, 0));
//            filteredMealsWithExceeded.forEach(System.out::println);
        }
    }
}

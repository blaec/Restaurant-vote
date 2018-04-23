package com.github.votes.web.in_memory;

import com.github.votes.model.Dish;
import com.github.votes.web.DishRestController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.votes.repository.mock_data.DishTestData.*;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml"})
@RunWith(SpringRunner.class)
public class InMemoryDishRestControllerSpringTest {

    @Autowired
    private DishRestController controller;

    @Test
    public void get() throws Exception {
        Dish dish = controller.get(DISH_ID_01);
        Assert.assertEquals(dish, DISH_01);
    }

    @Test
    public void getAll() throws Exception {
        List<Dish> dishes = controller.getAll();
        Assert.assertEquals(dishes, DISHES);
    }
}

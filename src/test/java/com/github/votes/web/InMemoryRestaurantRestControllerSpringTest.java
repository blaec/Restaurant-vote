package com.github.votes.web;

import com.github.votes.model.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.votes.repository.mock_data.RestaurantTestData.*;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringRunner.class)
public class InMemoryRestaurantRestControllerSpringTest {

    @Autowired
    private RestaurantRestController controller;

    @Test
    public void get() throws Exception {
        Restaurant restaurant = controller.get(RESTAURANT_ID_1);
        Assert.assertEquals(restaurant, RESTAURANT_1);
    }

    @Test
    public void getAll() throws Exception {
        List<Restaurant> restaurants = controller.getAll();
        Assert.assertEquals(restaurants, RESTAURANTS);
    }
}

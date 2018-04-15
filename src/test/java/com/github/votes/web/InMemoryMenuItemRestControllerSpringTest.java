package com.github.votes.web;

import com.github.votes.model.MenuItem;
import com.github.votes.repository.mock.InMemoryMenuItemRepositoryImpl;
import com.github.votes.util.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.github.votes.repository.mock_data.DishTestData.DISH_02;
import static com.github.votes.repository.mock_data.DishTestData.DISH_03;
import static com.github.votes.repository.mock_data.MenuItemTestData.*;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_1;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_3;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_ID_3;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringRunner.class)
public class InMemoryMenuItemRestControllerSpringTest {

    @Autowired
    private MenuItemRestController controller;

    @Autowired
    private InMemoryMenuItemRepositoryImpl repository;

    @Before
    public void setUp() throws Exception{
        repository.init();
    }

    @Test
    public void get() throws Exception {
        MenuItem menuItem = controller.get(MENU_ITEM_ID_01);
        Assert.assertEquals(menuItem, MENU_ITEM_01);
    }

    @Test
    public void getAll() throws Exception {
        List<MenuItem> menuItems = controller.getAll();
        Assert.assertEquals(menuItems, MENU_ITEMS);
    }

    @Test
    public void getByRestaurant() throws Exception {
        List<MenuItem> menuItems = controller.getByRestaurant(RESTAURANT_ID_3);
        Assert.assertEquals(menuItems, Arrays.asList(MENU_ITEM_03, MENU_ITEM_04));
    }

    @Test
    public void create() throws Exception {
        MenuItem menuItemCreated = new MenuItem(null, DISH_02, RESTAURANT_1, LocalDateTime.of(2001, 1, 1, 12, 12));
        MenuItem menuItem = controller.create(menuItemCreated);
        Assert.assertEquals(menuItem.getRestaurant(), menuItemCreated.getRestaurant());
    }

    @Test
    public void update() throws Exception {
        MenuItem menuItemUpdated = new MenuItem(MENU_ITEM_ID_02, DISH_03, RESTAURANT_3, LocalDateTime.of(2001, 1, 1, 12, 12));
        MenuItem menuItem = controller.update(menuItemUpdated);
        Assert.assertEquals(menuItem.getRestaurant(), RESTAURANT_3);
        Assert.assertEquals(menuItem.getDish(), DISH_03);
    }

    @Test
    public void delete() throws Exception {
        controller.delete(MENU_ITEM_ID_04);
        Assert.assertEquals(controller.getAll().size(), 3);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        controller.delete(MENU_ITEM_ID_04 + 1);
    }
}

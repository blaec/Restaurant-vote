package com.github.votes.service;

import com.github.votes.model.MenuItem;
import com.github.votes.util.exception.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;
import static com.github.votes.repository.mock_data.DishTestData.DISH_03;
import static com.github.votes.repository.mock_data.MenuItemTestData.*;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_2;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_ID_3;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MenuItemServiceTest {

    @Autowired
    private MenuItemService service;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp() throws Exception {
        cacheManager.getCache("menu_items").clear();
    }

/*
    @Test
    public void get() throws Exception {
        MenuItem menuItem = service.get(MENU_ITEM_ID_01);
        assertThat(MENU_ITEM_01).isEqualTo(menuItem);
    }
*/

    @Test(expected = NotFoundException.class)
    public void getNotFound() throws Exception {
        service.get(START_SEQ - 1);
    }

    @Test
    public void getAll() throws Exception {
        List<MenuItem> all = service.getAll();
        assertThat(all).containsAll(MENU_ITEMS);
    }

    @Test
    public void getByRestaurant() throws Exception {
        List<MenuItem> all = service.getByRestaurant(RESTAURANT_ID_3);
        assertThat(all).containsAll(MENU_ITEMS_REST);
    }

    @Test
    public void save() throws Exception {
        MenuItem created = new MenuItem(null, DISH_03, RESTAURANT_2, LocalDate.now());
        service.create(created);
        assertThat(service.getAll()).isEqualTo(Arrays.asList(MENU_ITEM_01, MENU_ITEM_02, MENU_ITEM_03, MENU_ITEM_04, MENU_ITEM_05, MENU_ITEM_06, MENU_ITEM_07, MENU_ITEM_08, created));
    }

    @Test
    public void delete() throws Exception {
        service.delete(MENU_ITEM_ID_03);
        assertThat(service.getAll()).isEqualTo(Arrays.asList(MENU_ITEM_01, MENU_ITEM_02, MENU_ITEM_04, MENU_ITEM_05, MENU_ITEM_06, MENU_ITEM_07, MENU_ITEM_08));
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(START_SEQ - 1);
    }
}

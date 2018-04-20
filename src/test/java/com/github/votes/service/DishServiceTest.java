package com.github.votes.service;

import com.github.votes.model.Dish;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.votes.repository.mock_data.DishTestData.DISHES;
import static com.github.votes.repository.mock_data.DishTestData.DISH_01;
import static com.github.votes.repository.mock_data.DishTestData.DISH_ID_01;
import static org.assertj.core.api.Assertions.assertThat;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class DishServiceTest {

    @Autowired
    private DishService service;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp() throws Exception {
        cacheManager.getCache("dishes").clear();
    }

    @Test
    public void get() throws Exception {
        Dish dish = service.get(DISH_ID_01);
        assertThat(DISH_01).isEqualTo(dish);
    }

    @Test
    public void getAll() throws Exception {
        List<Dish> all = service.getAll();
        assertThat(all).containsAll(DISHES);
    }
}

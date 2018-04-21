package com.github.votes.service;

import com.github.votes.model.User;
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

import java.util.List;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;
import static com.github.votes.repository.mock_data.UserTestData.*;
import static org.assertj.core.api.Assertions.assertThat;


@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest {

    @Autowired
    private UserService service;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void setUp() throws Exception {
        cacheManager.getCache("users").clear();
    }

    @Test
    public void get() throws Exception {
        User user = service.get(USER_ID_1);
        assertThat(USER_1).isEqualTo(user);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() throws Exception {
        service.get(START_SEQ - 1);
    }

    @Test
    public void getAll() throws Exception {
        List<User> all = service.getAll();
        assertThat(all).containsAll(USERS);
    }
}

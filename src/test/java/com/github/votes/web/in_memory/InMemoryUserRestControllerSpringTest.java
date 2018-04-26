package com.github.votes.web.in_memory;

import com.github.votes.model.User;
import com.github.votes.web.UserRestController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.votes.repository.mock_data.UserTestData.*;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml", "classpath:spring/spring-mvc.xml"})
@RunWith(SpringRunner.class)
public class InMemoryUserRestControllerSpringTest {

    @Autowired
    private UserRestController controller;

    @Test
    public void get() throws Exception {
        User user = controller.get(USER_ID_1);
        Assert.assertEquals(user, USER_1);
    }

    @Test
    public void getAll() throws Exception {
        List<User> users = controller.getAll();
        Assert.assertEquals(users, USERS);
    }
}

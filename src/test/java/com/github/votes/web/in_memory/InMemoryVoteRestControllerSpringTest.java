package com.github.votes.web.in_memory;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.Vote;
import com.github.votes.repository.mock.InMemoryVoteRepositoryImpl;
import com.github.votes.util.ValidationUtil;
import com.github.votes.web.VoteRestController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_2;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_3;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml", "classpath:spring/spring-mvc.xml"})
@RunWith(SpringRunner.class)
public class InMemoryVoteRestControllerSpringTest {

    private LocalDate date = LocalDate.of(2000,1,1);

    @Autowired
    private VoteRestController controller;

    @Autowired
    private InMemoryVoteRepositoryImpl repository;

    @Before
    public void setUp() throws Exception{
        repository.init();
        AuthorizedUser.setUser();
        ValidationUtil.setTimeVoteLimit(LocalTime.of(23, 59));
    }

    @After
    public void reset() throws Exception{
        AuthorizedUser.setAdmin();
        ValidationUtil.setTimeVoteLimit(LocalTime.of(11, 0));
    }

    @Test
    public void get() throws Exception{
        Vote vote = controller.get(date);
        Assert.assertEquals(vote.getRestaurant(), RESTAURANT_3);
    }

    @Test
    public void delete() throws Exception{
        controller.delete(date);
    }

    @Test
    public void updateVote() throws Exception{
        Assert.assertEquals(controller.get(date).getRestaurant(), RESTAURANT_3);
        controller.take(RESTAURANT_2);
        Assert.assertEquals(controller.get(date).getRestaurant(), RESTAURANT_2);
    }

    @Test
    public void takeVote() throws Exception{
        Assert.assertEquals(controller.get(date).getRestaurant(), RESTAURANT_3);
        controller.take(RESTAURANT_2);
        Assert.assertEquals(controller.get(date).getRestaurant(), RESTAURANT_2);
    }
}

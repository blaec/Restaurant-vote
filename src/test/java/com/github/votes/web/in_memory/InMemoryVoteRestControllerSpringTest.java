package com.github.votes.web.in_memory;

import com.github.votes.model.Vote;
import com.github.votes.repository.mock.InMemoryVoteRepositoryImpl;
import com.github.votes.web.VoteRestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_2;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_3;
import static com.github.votes.repository.mock_data.UserTestData.USER_1;
import static com.github.votes.repository.mock_data.UserTestData.USER_ID_1;

@ContextConfiguration({"classpath:spring/spring-app.xml", "classpath:spring/mock.xml", "classpath:spring/spring-mvc.xml"})
@RunWith(SpringRunner.class)
public class InMemoryVoteRestControllerSpringTest {

    @Autowired
    private VoteRestController controller;

    @Autowired
    private InMemoryVoteRepositoryImpl repository;

    @Before
    public void setUp() throws Exception{
        repository.init();
    }

    @Test
    public void get() throws Exception{
        Vote vote = controller.get();
        Assert.assertEquals(vote.getRestaurant(), RESTAURANT_3);
    }

    @Test
    public void delete() throws Exception{
        controller.delete();
    }

    @Test
    public void updateVote() throws Exception{
        Assert.assertEquals(controller.get().getRestaurant(), RESTAURANT_3);
        Vote vote = new Vote(USER_ID_1, RESTAURANT_2, USER_1, LocalDateTime.of(2000, 1, 1, 1, 1));
        controller.take(vote);
        Assert.assertEquals(controller.get().getRestaurant(), RESTAURANT_2);
    }

    @Test
    public void takeVote() throws Exception{
        Assert.assertEquals(controller.get().getRestaurant(), RESTAURANT_3);
        Vote vote = new Vote(null, RESTAURANT_2, USER_1, LocalDateTime.of(2000, 1, 1, 1, 1));
        controller.take(vote);
        Assert.assertEquals(controller.get().getRestaurant(), RESTAURANT_2);
    }
}

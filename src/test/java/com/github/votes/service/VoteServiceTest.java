package com.github.votes.service;

import com.github.votes.model.Vote;
import com.github.votes.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;
import static com.github.votes.repository.mock_data.UserTestData.USER_ID_1;
import static com.github.votes.repository.mock_data.UserTestData.USER_ID_2;
import static com.github.votes.repository.mock_data.VoteTestData.VOTE_01;
import static com.github.votes.repository.mock_data.VoteTestData.VOTE_02;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class VoteServiceTest {

    @Autowired
    private VoteService service;

    @Autowired
    private UserService userService;

     @Autowired
    private RestaurantService restaurantService;

    @Test
    public void get() throws Exception {
        Vote vote = service.get(USER_ID_1);
//        vote.setUser(userService.get(vote.getUser().getId()));
//        vote.setRestaurant(restaurantService.get(vote.getRestaurant().getId()));
        assertThat(VOTE_01).isEqualTo(vote);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() throws Exception {
        service.get(START_SEQ - 1);
    }

    @Test
    public void save() throws Exception {
        service.save(VOTE_02, USER_ID_2);
        assertThat(VOTE_02).isEqualTo(service.get(USER_ID_2));
    }

    @Test
    public void delete() throws Exception {
        service.delete(USER_ID_1);
//        assertThat(((DataJpaVoteRepository) ((VoteServiceImpl) service).repository).crudRepository.findAll().size() == 0);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(START_SEQ - 1);
    }
}
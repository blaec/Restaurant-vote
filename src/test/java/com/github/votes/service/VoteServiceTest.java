package com.github.votes.service;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.Vote;
import com.github.votes.util.ValidationUtil;
import com.github.votes.util.exception.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_2;
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

    private LocalDate date = LocalDate.of(2001,1,1);

    @Autowired
    private VoteService service;

    @Before
    public void setUp() {
        AuthorizedUser.setUser();
        ValidationUtil.setTimeVoteLimit(LocalTime.of(23, 59));
    }

    @After
    public void reset() {
        AuthorizedUser.setAdmin();
        ValidationUtil.setTimeVoteLimit(LocalTime.of(11, 0));
    }

    @Test
    public void get() throws Exception {
        // ToDo repository contains history data for the same user
        Vote vote = service.get(USER_ID_1, date);
        assertThat(VOTE_01).isEqualTo(vote);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() throws Exception {
        service.get(START_SEQ - 1, date);
    }

    @Test
    public void save() throws Exception {
        service.save(RESTAURANT_2, USER_ID_2);
        assertThat(VOTE_02.getRestaurant()).isEqualTo(service.get(USER_ID_2, date).getRestaurant());
        assertThat(VOTE_02.getUser()).isEqualTo(service.get(USER_ID_2, date).getUser());
    }

    @Test
    public void delete() throws Exception {
//        AuthorizedUser.setUser();
        service.delete(USER_ID_1, date);
//        AuthorizedUser.setAdmin();
        // TODO required getAll to check delete status, statement below works only with manual debug
//        assertThat(((DataJpaVoteRepository) ((VoteServiceImpl) service).repository).crudRepository.findAll().size() == 0);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(START_SEQ - 1, date);
    }
}

package com.github.votes.web;

import com.github.votes.AuthorizedUser;
import com.github.votes.util.ValidationUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.time.LocalTime;

import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_5;
import static com.github.votes.web.json.JacksonObjectMapper.getMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class VoteRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = VoteRestController.REST_URL + '/';

    @Before
    public void setUp() {
        AuthorizedUser.setUser();
        ValidationUtil.setTimeVoteLimit(LocalTime.of(23, 59));
    }

    @After
    public void reset() throws Exception {
        AuthorizedUser.setAdmin();
        ValidationUtil.setTimeVoteLimit(LocalTime.of(11, 0));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL)
                .param("date", "2001-01-02"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL + "/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL)
                .param("date", "2001-01-01"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testTake() throws Exception {
        mockMvc.perform(put(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(RESTAURANT_5)))
                .andExpect(status().isOk());
    }
}

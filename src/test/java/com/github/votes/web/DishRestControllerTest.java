package com.github.votes.web;

import org.junit.Test;

import static com.github.votes.repository.mock_data.DishTestData.DISH_ID_01;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DishRestControllerTest extends AbstractControllerTest{
    private static final String REST_URL = DishRestController.REST_URL + '/';

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + DISH_ID_01))
                .andDo(print())
                .andExpect(status().isOk());
//                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
//                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}

package com.github.votes.web;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.MenuItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import static com.github.votes.repository.mock_data.DishTestData.DISH_05;
import static com.github.votes.repository.mock_data.MenuItemTestData.*;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_2;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_ID_3;
import static com.github.votes.web.json.JacksonObjectMapper.getMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MealItemRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = MenuItemRestController.REST_URL + '/';

    @Before
    public void setUp() {
        AuthorizedUser.setAdmin();
    }

    @After
    public void reset() throws Exception {
        AuthorizedUser.setUser();
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllByDate() throws Exception {
        mockMvc.perform(get(REST_URL + "filter")
                .param("date", "2001-01-01"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllByRestaurantId() throws Exception {
        mockMvc.perform(get(REST_URL + "restaurant/" + RESTAURANT_ID_3))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetAllByRestaurantIdAndDate() throws Exception {
        mockMvc.perform(get(REST_URL + "restaurant/filter")
                .param("id", "100017")
                .param("date", "2001-01-01"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + MENU_ITEM_ID_02))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void testCreate() throws Exception {
        MenuItem created = MENU_ITEM_08;
        created.setRestaurant(RESTAURANT_2);
        created.setDish(DISH_05);

        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(created)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdate() throws Exception {
        MenuItem updated = MENU_ITEM_05;
        updated.setRestaurant(RESTAURANT_2);
        updated.setDish(DISH_05);

        mockMvc.perform(put(REST_URL + MENU_ITEM_ID_05)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(updated)))
                .andExpect(status().isOk());
    }
}

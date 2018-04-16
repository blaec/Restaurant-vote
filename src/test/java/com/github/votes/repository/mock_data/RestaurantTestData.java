package com.github.votes.repository.mock_data;

import com.github.votes.model.Restaurant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;

public class RestaurantTestData {
    public static final int RESTAURANT_ID_1 = START_SEQ + 15;
    public static final int RESTAURANT_ID_2 = START_SEQ + 16;
    public static final int RESTAURANT_ID_3 = START_SEQ + 17;
    public static final int RESTAURANT_ID_4 = START_SEQ + 18;
    public static final int RESTAURANT_ID_5 = START_SEQ + 19;

    public static final Restaurant RESTAURANT_1 = new Restaurant(RESTAURANT_ID_1, "restaurant_1");
    public static final Restaurant RESTAURANT_2 = new Restaurant(RESTAURANT_ID_2, "restaurant_2");
    public static final Restaurant RESTAURANT_3 = new Restaurant(RESTAURANT_ID_3, "restaurant_3");
    public static final Restaurant RESTAURANT_4 = new Restaurant(RESTAURANT_ID_4, "restaurant_4");
    public static final Restaurant RESTAURANT_5 = new Restaurant(RESTAURANT_ID_5, "restaurant_5");

    public static final List<Restaurant> RESTAURANTS = Collections.unmodifiableList(Arrays.asList(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3, RESTAURANT_4, RESTAURANT_5));
}

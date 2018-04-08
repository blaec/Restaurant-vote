package com.github.votes.repository.mock_data;

import com.github.votes.model.Dish;

import java.util.Arrays;
import java.util.List;

import static com.github.votes.model.AbstactBaseEntiry.START_SEQ;

public class DishTestData {
    public static final int DISH_ID_01 = START_SEQ + 10;
    public static final int DISH_ID_02 = START_SEQ + 11;
    public static final int DISH_ID_03 = START_SEQ + 12;
    public static final int DISH_ID_04 = START_SEQ + 13;
    public static final int DISH_ID_05 = START_SEQ + 14;
    public static final int DISH_ID_06 = START_SEQ + 15;
    public static final int DISH_ID_07 = START_SEQ + 16;
    public static final int DISH_ID_08 = START_SEQ + 17;
    public static final int DISH_ID_09 = START_SEQ + 18;
    public static final int DISH_ID_10 = START_SEQ + 19;

    public static final Dish DISH_01 = new Dish(DISH_ID_01, "dish_01", 100);
    public static final Dish DISH_02 = new Dish(DISH_ID_02, "dish_02", 200);
    public static final Dish DISH_03 = new Dish(DISH_ID_03, "dish_03", 50);
    public static final Dish DISH_04 = new Dish(DISH_ID_04, "dish_04", 70);
    public static final Dish DISH_05 = new Dish(DISH_ID_05, "dish_05", 150);
    public static final Dish DISH_06 = new Dish(DISH_ID_06, "dish_06", 210);
    public static final Dish DISH_07 = new Dish(DISH_ID_07, "dish_07", 90);
    public static final Dish DISH_08 = new Dish(DISH_ID_08, "dish_08", 120);
    public static final Dish DISH_09 = new Dish(DISH_ID_09, "dish_09", 1000);
    public static final Dish DISH_10 = new Dish(DISH_ID_10, "dish_10", 10);

    public static final List<Dish> DISHES = Arrays.asList(DISH_01, DISH_02, DISH_03, DISH_04, DISH_05, DISH_06, DISH_07, DISH_08, DISH_09, DISH_10);
}

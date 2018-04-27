package com.github.votes.repository.mock_data;

import com.github.votes.model.MenuItem;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;
import static com.github.votes.repository.mock_data.DishTestData.*;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_1;
import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_3;

public class MenuItemTestData {
    public static final int MENU_ITEM_ID_01 = START_SEQ + 20;
    public static final int MENU_ITEM_ID_02 = START_SEQ + 21;
    public static final int MENU_ITEM_ID_03 = START_SEQ + 22;
    public static final int MENU_ITEM_ID_04 = START_SEQ + 23;
    public static final int MENU_ITEM_ID_05 = START_SEQ + 24;
    public static final int MENU_ITEM_ID_06 = START_SEQ + 25;
    public static final int MENU_ITEM_ID_07 = START_SEQ + 26;
    public static final int MENU_ITEM_ID_08 = START_SEQ + 27;

    public static final MenuItem MENU_ITEM_01 = new MenuItem(MENU_ITEM_ID_01, DISH_01, RESTAURANT_1, LocalDate.of(2001, 1, 1));
    public static final MenuItem MENU_ITEM_02 = new MenuItem(MENU_ITEM_ID_02, DISH_02, RESTAURANT_1, LocalDate.of(2001, 1, 1));
    public static final MenuItem MENU_ITEM_03 = new MenuItem(MENU_ITEM_ID_03, DISH_01, RESTAURANT_3, LocalDate.of(2001, 1, 1));
    public static final MenuItem MENU_ITEM_04 = new MenuItem(MENU_ITEM_ID_04, DISH_04, RESTAURANT_3, LocalDate.of(2001, 1, 1));
    public static final MenuItem MENU_ITEM_05 = new MenuItem(MENU_ITEM_ID_05, DISH_01, RESTAURANT_1, LocalDate.of(2001, 1, 2));
    public static final MenuItem MENU_ITEM_06 = new MenuItem(MENU_ITEM_ID_06, DISH_02, RESTAURANT_1, LocalDate.of(2001, 1, 2));
    public static final MenuItem MENU_ITEM_07 = new MenuItem(MENU_ITEM_ID_07, DISH_03, RESTAURANT_3, LocalDate.of(2001, 1, 2));
    public static final MenuItem MENU_ITEM_08 = new MenuItem(MENU_ITEM_ID_08, DISH_04, RESTAURANT_3, LocalDate.of(2001, 1, 2));

    public static final List<MenuItem> MENU_ITEMS = Collections.unmodifiableList(Arrays.asList(MENU_ITEM_01, MENU_ITEM_02, MENU_ITEM_03, MENU_ITEM_04, MENU_ITEM_05, MENU_ITEM_06, MENU_ITEM_07, MENU_ITEM_08));
    public static final List<MenuItem> MENU_ITEMS_REST = Collections.unmodifiableList(Arrays.asList(MENU_ITEM_03, MENU_ITEM_04));
}

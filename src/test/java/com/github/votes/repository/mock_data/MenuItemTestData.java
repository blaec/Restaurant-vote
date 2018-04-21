package com.github.votes.repository.mock_data;

import com.github.votes.model.MenuItem;

import java.time.LocalDateTime;
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

    public static final MenuItem MENU_ITEM_01 = new MenuItem(MENU_ITEM_ID_01, DISH_01, RESTAURANT_1, LocalDateTime.of(2001,1,1,11,11));
    public static final MenuItem MENU_ITEM_02 = new MenuItem(MENU_ITEM_ID_02, DISH_02, RESTAURANT_1, LocalDateTime.of(2001,1,1,12,12));
    public static final MenuItem MENU_ITEM_03 = new MenuItem(MENU_ITEM_ID_03, DISH_01, RESTAURANT_3, LocalDateTime.of(2001,1,1,13,13));
    public static final MenuItem MENU_ITEM_04 = new MenuItem(MENU_ITEM_ID_04, DISH_04, RESTAURANT_3, LocalDateTime.of(2001,1,1,14,14));

    public static final List<MenuItem> MENU_ITEMS = Collections.unmodifiableList(Arrays.asList(MENU_ITEM_01, MENU_ITEM_02, MENU_ITEM_03, MENU_ITEM_04));
    public static final List<MenuItem> MENU_ITEMS_REST = Collections.unmodifiableList(Arrays.asList(MENU_ITEM_03, MENU_ITEM_04));
}

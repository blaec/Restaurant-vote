package com.github.votes.repository;

import com.github.votes.model.MenuItem;

import java.util.List;

public interface MenuItemRepository extends DataRepository<MenuItem> {

    List<MenuItem> getByRestaurant(int restaurantId);

    MenuItem save(MenuItem menuItem);

    boolean delete(int id);
}

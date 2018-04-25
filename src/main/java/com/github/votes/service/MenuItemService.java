package com.github.votes.service;

import com.github.votes.model.MenuItem;
import com.github.votes.util.exception.NotFoundException;

import java.util.List;

public interface MenuItemService {

    MenuItem get(int id) throws NotFoundException;

    List<MenuItem> getAll();

    List<MenuItem> getByRestaurant(int restaurantId) throws NotFoundException;

    MenuItem create(MenuItem menuItem);

    MenuItem update(MenuItem menuItem, int id);

    void delete(int id) throws NotFoundException;
}

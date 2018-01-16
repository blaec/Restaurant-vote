package com.github.votes.repository;

import com.github.votes.model.Dish;

import java.util.List;

public interface DishRepository {
    Dish get(int id);

    Dish add(Dish dish);

    boolean delete(int id);

    List<Dish> getAllByRestaurant(int restaurantId);
}

package com.github.votes.repository;

import com.github.votes.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant input(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    List<Restaurant> getAll();
}

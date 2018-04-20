package com.github.votes.repository.datajpa;

import com.github.votes.model.Restaurant;
import com.github.votes.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {
    @Override
    public Restaurant get(int id) {
        return null;
    }

    @Override
    public List<Restaurant> getAll() {
        return null;
    }
}

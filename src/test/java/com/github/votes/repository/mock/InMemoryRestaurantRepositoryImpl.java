package com.github.votes.repository.mock;

import com.github.votes.model.Restaurant;
import com.github.votes.repository.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.github.votes.repository.mock_data.RestaurantTestData.*;

@Repository
public class InMemoryRestaurantRepositoryImpl implements RestaurantRepository {

    private Map<Integer, Restaurant> repository = new ConcurrentHashMap<>();

    {
        repository.clear();
        repository.put(RESTAURANT_ID_1, RESTAURANT_1);
        repository.put(RESTAURANT_ID_2, RESTAURANT_2);
        repository.put(RESTAURANT_ID_3, RESTAURANT_3);
        repository.put(RESTAURANT_ID_4, RESTAURANT_4);
        repository.put(RESTAURANT_ID_5, RESTAURANT_5);
    }

    @Override
    public Restaurant get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return new ArrayList<>(repository.values());
    }
}

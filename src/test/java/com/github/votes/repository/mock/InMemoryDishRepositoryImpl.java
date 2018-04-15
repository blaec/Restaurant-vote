package com.github.votes.repository.mock;

import com.github.votes.model.Dish;
import com.github.votes.repository.DishRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.github.votes.repository.mock_data.DishTestData.*;

@Repository
public class InMemoryDishRepositoryImpl implements DishRepository {

    private Map<Integer, Dish> repository = new ConcurrentHashMap<>();

    {
        repository.clear();
        repository.put(DISH_ID_01, DISH_01);
        repository.put(DISH_ID_02, DISH_02);
        repository.put(DISH_ID_03, DISH_03);
        repository.put(DISH_ID_04, DISH_04);
        repository.put(DISH_ID_05, DISH_05);
        repository.put(DISH_ID_06, DISH_06);
        repository.put(DISH_ID_07, DISH_07);
        repository.put(DISH_ID_08, DISH_08);
        repository.put(DISH_ID_09, DISH_09);
        repository.put(DISH_ID_10, DISH_10);
    }

    @Override
    public Dish get(int id) {
        return repository.get(id);
    }

    @Override
    public List<Dish> getAll() {
        return new ArrayList<>(repository.values());
    }
}

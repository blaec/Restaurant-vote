package com.github.votes.repository.datajpa;

import com.github.votes.model.Dish;
import com.github.votes.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaDishRepository implements DishRepository {
    private static final Sort SORT_ID = new Sort(Sort.Direction.ASC, "id");

    @Autowired
    private CrudDishRepository crudRepository;


    @Override
    public Dish get(int id) {
        return crudRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dish> getAll() {
        return crudRepository.findAll(SORT_ID);
    }
}

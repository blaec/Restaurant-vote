package com.github.votes.service.implementations;

import com.github.votes.model.Dish;
import com.github.votes.repository.DishRepository;
import com.github.votes.service.DishService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.votes.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishServiceImpl implements DishService {

    private final DishRepository repository;

    @Autowired
    public DishServiceImpl(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public Dish get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Cacheable("dishes")
    @Override
    public List<Dish> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(Dish::getId))
                .collect(Collectors.toList());
    }
}

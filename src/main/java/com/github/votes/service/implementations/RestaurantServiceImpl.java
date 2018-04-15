package com.github.votes.service.implementations;

import com.github.votes.model.Restaurant;
import com.github.votes.repository.RestaurantRepository;
import com.github.votes.service.RestaurantService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.votes.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(Restaurant::getId))
                .collect(Collectors.toList());
    }
}

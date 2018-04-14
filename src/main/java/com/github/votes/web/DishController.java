package com.github.votes.web;

import com.github.votes.model.Dish;
import com.github.votes.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = DishController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishController {
    static final String REST_URL = "/rest/profile/dish";

    @Autowired
    private DishService service;

    @GetMapping("/{id}")
    public Dish get(@PathVariable("id") int id) {
        return service.get(id);
    }

    @GetMapping
    public List<Dish> getAll() {
        return service.getAll();
    }
}

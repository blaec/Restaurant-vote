package com.github.votes.web;

import org.slf4j.Logger;
import com.github.votes.model.Dish;
import com.github.votes.service.DishService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping(value = DishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishRestController {
    static final String REST_URL = "/rest/profile/dish";
    private final Logger log = LoggerFactory.getLogger(DishRestController.class);

    @Autowired
    private DishService service;

    @GetMapping("/{id}")
    public Dish get(@PathVariable("id") int id) {
        log.info("get dish with id {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<Dish> getAll() {
        log.info("get list of all dishes");
        return service.getAll();
    }
}

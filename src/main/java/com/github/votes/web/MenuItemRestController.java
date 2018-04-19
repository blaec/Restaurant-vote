package com.github.votes.web;

import com.github.votes.model.MenuItem;
import com.github.votes.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = MenuItemRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuItemRestController {
    static final String REST_URL = "/rest/profile/menu_item";
    private final Logger log = LoggerFactory.getLogger(MenuItemRestController.class);

    @Autowired
    private MenuItemService service;

    @GetMapping("/{id}")
    public MenuItem get(@PathVariable("id") int id) {
        log.info("get MenuItem with id {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<MenuItem> getAll(){
        log.info("get list of all MenuItems");
        return service.getAll();
    }

    @GetMapping(value = "/restaurant/{id}")
    public List<MenuItem> getByRestaurant(@PathVariable("id") int restaurantId) {
        log.info("get list of all MenuItem by restaurant id {}", restaurantId);
        return service.getByRestaurant(restaurantId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem create(MenuItem menuItem){
        log.info("create {}", menuItem);
        return service.create(menuItem);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem update(MenuItem menuItem) {
        log.info("update {}", menuItem);
        return service.update(menuItem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        log.info("delete MenuItem with id {}", id);
        service.delete(id);
    }
}
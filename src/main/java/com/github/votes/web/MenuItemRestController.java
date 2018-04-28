package com.github.votes.web;

import com.github.votes.model.MenuItem;
import com.github.votes.service.MenuItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = MenuItemRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuItemRestController {
    static final String REST_URL = "/rest/menu_items";
    private final Logger log = LoggerFactory.getLogger(MenuItemRestController.class);

    @Autowired
    private MenuItemService service;

    @GetMapping("/{id}")
    public MenuItem get(@PathVariable("id") int id) {
        log.info("get MenuItem with id {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<MenuItem> getAll() {
        log.info("get list of all MenuItems");
        return service.getAll();
    }

    @GetMapping("/filter")
    public List<MenuItem> getAllByDate(@RequestParam(value = "date", required = false)
                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("get list of all MenuItems for specified date {} (today by default)", date);
        return service.getAllByDate(date != null ? date : LocalDate.now());
    }

    @GetMapping(value = "/restaurant/{id}")
    public List<MenuItem> getByRestaurant(@PathVariable("id") int restaurantId) {
        log.info("get list of all MenuItem by restaurant id {}", restaurantId);
        return service.getByRestaurant(restaurantId);
    }

    @GetMapping(value = "/restaurant/filter")
    public List<MenuItem> getByRestaurantAndDate(@RequestParam("id") int restaurantId,
                                                 @RequestParam(value = "date", required = false)
                                                 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("get list of all MenuItem by restaurant id {} for specified date {} (today by default)", restaurantId, date);
        return service.getByRestaurantAndDate(restaurantId, date != null ? date : LocalDate.now());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem create(@RequestBody MenuItem menuItem) {
        log.info("create {}", menuItem);
        return service.create(menuItem);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public MenuItem update(@RequestBody MenuItem menuItem, @PathVariable("id") int id) {
        log.info("update {}", menuItem);
        return service.update(menuItem, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        log.info("delete MenuItem with id {}", id);
        service.delete(id);
    }
}

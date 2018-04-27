package com.github.votes.web;

import com.github.votes.model.User;
import com.github.votes.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = UserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController {
    static final String REST_URL = "/rest/users";
    private final Logger log = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id) {
        log.info("get user with id {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<User> getAll() {
        log.info("get list of all users");
        return service.getAll();
    }
}

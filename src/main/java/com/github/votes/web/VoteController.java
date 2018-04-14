package com.github.votes.web;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.Vote;
import com.github.votes.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    static final String REST_URL = "/rest/profile/vote";

    @Autowired
    private VoteService service;

    @GetMapping("/{id}")
    public Vote get(@PathVariable("id") int restaurantId) {
        int userId = AuthorizedUser.id();
        return service.get(userId, restaurantId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int restaurantId) {
        int userId = AuthorizedUser.id();
        service.delete(userId, restaurantId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote update(Vote vote, @PathVariable("id") int restaurantId) {
        int userId = AuthorizedUser.id();
        return service.update(vote, userId, restaurantId);
    }
}

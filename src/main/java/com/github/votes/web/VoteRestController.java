package com.github.votes.web;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.Vote;
import com.github.votes.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/profile/vote";

    @Autowired
    private VoteService service;

    @GetMapping("/{id}")
    public Vote get(@PathVariable("id") int id) {
        int userId = AuthorizedUser.id();
        return service.get(id, userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        int userId = AuthorizedUser.id();
        service.delete(id, userId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote save(Vote vote) {
        int userId = AuthorizedUser.id();
        return service.save(vote, userId);
    }
}

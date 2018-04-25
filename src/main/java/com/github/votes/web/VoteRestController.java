package com.github.votes.web;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.Vote;
import com.github.votes.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/profile/votes";
    private final Logger log = LoggerFactory.getLogger(VoteRestController.class);

    @Autowired
    private VoteService service;

    @GetMapping
    public Vote get() {
        int userId = AuthorizedUser.id();
        log.info("get vote for user {}", userId);
        return service.get(userId);
    }

    @DeleteMapping
    public void delete() {
        int userId = AuthorizedUser.id();
        log.info("delete vote for user {}", userId);
        service.delete(userId);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote take(Vote vote) {
        int userId = AuthorizedUser.id();
        log.info("take a vote {} for user {}", vote, userId);
        return service.save(vote, userId);
    }
}

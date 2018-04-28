package com.github.votes.web;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.Restaurant;
import com.github.votes.model.Vote;
import com.github.votes.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.github.votes.util.DateUtil.getDefault;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/votes";
    private final Logger log = LoggerFactory.getLogger(VoteRestController.class);

    @Autowired
    private VoteService service;

    @GetMapping()
    public Vote get(@RequestParam(value = "date", required = false)
                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        int userId = AuthorizedUser.id();
        log.info("get vote for user {} for specified date {} (today by default)", userId, date);
        return service.get(userId, getDefault(date));
    }

    @GetMapping("/all")
    public List<Vote> getAll(){
        log.info("get list of all Votes");
        return service.getAll();
    }

    @DeleteMapping
    public void delete(@RequestParam(value = "date", required = false)
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        int userId = AuthorizedUser.id();
        log.info("delete vote for user {} for specified date {} (today by default)", userId, date);
        service.delete(userId, getDefault(date));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote take(@RequestBody Restaurant restaurant) {
        int userId = AuthorizedUser.id();
        log.info("vote for restaurant {} and user {}", restaurant, userId);
        return service.save(restaurant, userId);
    }
}

package com.github.votes.service;

import com.github.votes.model.Restaurant;
import com.github.votes.model.Vote;
import com.github.votes.util.exception.NotFoundException;

public interface VoteService {

    Vote get(int userId) throws NotFoundException;

    void delete(int userId) throws NotFoundException;

    Vote save(Restaurant restaurant, int userId);
}

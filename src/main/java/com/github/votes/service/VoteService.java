package com.github.votes.service;

import com.github.votes.model.Vote;
import com.github.votes.util.exception.NotFoundException;

public interface VoteService {

    Vote get(int userId, int restaurantId) throws NotFoundException;

    void delete(int userId, int restaurantId) throws NotFoundException;

    Vote update(Vote vote, int userId, int restaurantId);
}

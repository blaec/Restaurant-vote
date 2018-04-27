package com.github.votes.service;

import com.github.votes.model.Restaurant;
import com.github.votes.model.Vote;
import com.github.votes.util.exception.NotFoundException;

import java.util.List;

public interface VoteService {

    List<Vote> getAll();

    Vote get(int userId) throws NotFoundException;

    void delete(int userId) throws NotFoundException;

    Vote save(Restaurant restaurant, int userId);
}

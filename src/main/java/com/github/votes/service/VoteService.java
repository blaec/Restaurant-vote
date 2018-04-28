package com.github.votes.service;

import com.github.votes.model.Restaurant;
import com.github.votes.model.Vote;
import com.github.votes.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    List<Vote> getAll();

    Vote get(int userId, LocalDate date) throws NotFoundException;

    void delete(int userId, LocalDate date) throws NotFoundException;

    Vote save(Restaurant restaurant, int userId);
}

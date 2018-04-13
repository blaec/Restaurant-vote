package com.github.votes.repository;

import com.github.votes.model.Vote;

public interface VoteRepository {

    Vote get(int userId, int restaurantId);

    Vote update(Vote vote, int userId, int restaurantId);

    boolean delete(int userId, int restaurantId);
}

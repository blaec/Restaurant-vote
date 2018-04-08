package com.github.votes.repository;

import com.github.votes.model.Vote;

public interface VoteRepository {

    Vote get(int id);

    Vote save(Vote vote, int userId, int restaurantId);

    boolean delete(int id);
}

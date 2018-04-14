package com.github.votes.repository;

import com.github.votes.model.Vote;

public interface VoteRepository {

    Vote get(int id, int userId);

    Vote save(Vote vote, int userId);

    boolean delete(int id, int userId);
}

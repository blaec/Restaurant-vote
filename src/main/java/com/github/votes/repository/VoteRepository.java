package com.github.votes.repository;

import com.github.votes.model.Vote;

public interface VoteRepository extends DataRepository<Vote> {

    Vote save(Vote vote, int userId);

    boolean delete(int userId);
}

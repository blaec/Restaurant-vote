package com.github.votes.repository.datajpa;

import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaVoteRepository implements VoteRepository {
    @Override
    public Vote get(int userId) {
        return null;
    }

    @Override
    public Vote save(Vote vote, int userId) {
        return null;
    }

    @Override
    public boolean delete(int userId) {
        return false;
    }
}

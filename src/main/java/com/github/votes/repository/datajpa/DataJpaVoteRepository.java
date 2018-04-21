package com.github.votes.repository.datajpa;

import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataJpaVoteRepository implements VoteRepository {

    @Autowired
    private CrudVoteRepository crudRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public Vote get(int userId) {
        return crudRepository.getByUserId(userId);
    }

    @Override
    public Vote save(Vote vote, int userId) {
        if (!vote.isNew() && get(vote.getId()) == null) {
            return null;
        }
        vote.setUser(crudUserRepository.getOne(userId));
        return crudRepository.save(vote);
    }

    @Override
    public boolean delete(int userId) {
        return crudRepository.delete(userId) != 0;
    }
}

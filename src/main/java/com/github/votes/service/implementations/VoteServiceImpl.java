package com.github.votes.service.implementations;

import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;
import com.github.votes.service.VoteService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.github.votes.util.ValidationUtil.checkNotFoundWithId;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vote get(int userId, int restaurantId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(userId, restaurantId), userId);
    }

    @Override
    public void delete(int userId, int restaurantId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(userId, restaurantId), userId);
    }

    @Override
    public Vote update(Vote vote, int id, int restaurantId) {
        return repository.update(vote, id, restaurantId);
    }
}

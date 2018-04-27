package com.github.votes.service.implementations;

import com.github.votes.model.Restaurant;
import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;
import com.github.votes.service.VoteService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.github.votes.util.ValidationUtil.checkNotFoundWithId;
import static com.github.votes.util.ValidationUtil.checkVoteTimeLimit;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Vote get(int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(userId), userId);
    }

    @Override
    public void delete(int userId) throws NotFoundException {
        checkNotFoundWithId(repository.delete(userId), userId);
    }

    @Override
    public Vote save(Restaurant restaurant, int userId) {
        LocalDateTime taken = LocalDateTime.now();
        checkVoteTimeLimit(taken);
        if (repository.get(userId) != null) {
            delete(userId);
        }
        Vote newVote = new Vote(null, restaurant, null, taken);
        return repository.save(newVote, userId);
    }
}

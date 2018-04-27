package com.github.votes.service.implementations;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.Restaurant;
import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;
import com.github.votes.service.VoteService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.votes.model.Role.ROLE_USER;
import static com.github.votes.util.ValidationUtil.*;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository repository;

    @Autowired
    public VoteServiceImpl(VoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vote> getAll() {
        return sortById(repository.getAll());
    }

    @Override
    public Vote get(int userId) throws NotFoundException {
        return checkNotFoundWithId(repository.get(userId), userId);
    }

    @Override
    public void delete(int userId) throws NotFoundException {
        checkRole(AuthorizedUser.getRole(), ROLE_USER);
        checkNotFoundWithId(repository.delete(userId), userId);
    }

    @Override
    public Vote save(Restaurant restaurant, int userId) {
        checkRole(AuthorizedUser.getRole(), ROLE_USER);
        LocalDateTime taken = LocalDateTime.now();
        checkVoteTimeLimit(taken);
        if (repository.get(userId) != null) {
            delete(userId);
        }
        Vote newVote = new Vote(null, restaurant, null, taken);
        return repository.save(newVote, userId);
    }

    private List<Vote> sortById(List<Vote> unsorted) {
        return unsorted.stream()
                .sorted(Comparator.comparing(Vote::getId))
                .collect(Collectors.toList());
    }
}

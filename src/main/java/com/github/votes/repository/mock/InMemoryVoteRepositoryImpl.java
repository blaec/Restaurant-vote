package com.github.votes.repository.mock;

import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryVoteRepositoryImpl implements VoteRepository {

    private Map<Integer, Map<Integer, Vote>> repository = new ConcurrentHashMap<>();

    @Override
    public Vote get(int userId, int restaurantId) {
        Map<Integer, Vote> restaurants = repository.get(userId);
        return restaurants == null ? null : restaurants.get(restaurantId);
    }

    @Override
    public Vote update(Vote vote, int userId, int restaurantId) {
        Objects.requireNonNull(vote);
        Map<Integer, Vote> restaurants = repository.get(userId);
        return restaurants.computeIfPresent(vote.getId(), (id, oldVote) -> vote);
    }

    @Override
    public boolean delete(int userId, int restaurantId) {
        Vote vote = get(userId, restaurantId);
        vote.setTaken(null);
        return update(vote, userId, restaurantId) != null;
    }
}

package com.github.votes.repository.mock;

import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryVoteRepositoryImpl implements VoteRepository {

    private Map<Integer, Map<Integer, Vote>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public Vote get(int id, int userId) {
        Map<Integer, Vote> votes = repository.get(userId);
        return votes == null ? null : votes.get(id);
    }

    @Override
    public Vote save(Vote vote, int userId) {
        Map<Integer, Vote> votes = repository.computeIfAbsent(userId, ConcurrentHashMap::new);
        if (vote.isNew()) {
            vote.setId(counter.incrementAndGet());
            votes.put(vote.getId(), vote);
            return vote;
        }
        return votes.computeIfPresent(vote.getId(), (id, oldMeal) -> vote);
    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer, Vote> votes = repository.get(userId);
        return votes != null && votes.remove(id) != null;
    }
}

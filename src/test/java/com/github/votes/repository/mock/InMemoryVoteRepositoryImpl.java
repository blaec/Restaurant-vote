package com.github.votes.repository.mock;

import com.github.votes.model.Vote;
import com.github.votes.repository.VoteRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.github.votes.repository.mock_data.RestaurantTestData.RESTAURANT_3;
import static com.github.votes.repository.mock_data.UserTestData.USER_1;
import static com.github.votes.repository.mock_data.UserTestData.USER_ID_1;

@Repository
public class InMemoryVoteRepositoryImpl implements VoteRepository {

    private Map<Integer, Vote> repository = new ConcurrentHashMap<>();

    public void init(){
        repository.clear();
        repository.put(USER_ID_1, new Vote(USER_ID_1, RESTAURANT_3, USER_1, LocalDateTime.of(2000,1,1,1,1)));
    }

    @Override
    public Vote get(int userId, LocalDate date) {
        return repository.get(userId);
    }

    @Override
    public List<Vote> getAll() {
        return null;
    }

    @Override
    public Vote save(Vote vote, int userId) {
        if (vote.isNew()) {
            vote.setId(userId);
            repository.put(vote.getId(), vote);
            return vote;
        }
        return repository.computeIfPresent(vote.getId(), (id, oldMeal) -> vote);
    }

    @Override
    public boolean delete(int userId, LocalDate date) {
        return repository.remove(userId) != null;
    }
}

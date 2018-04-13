package com.github.votes.repository.mock;

import com.github.votes.model.User;
import com.github.votes.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.github.votes.repository.mock_data.UserTestData.*;

@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {

    private Map<Integer, User> repository = new ConcurrentHashMap<>();

    public void init() {
        repository.clear();
        repository.put(ADMIN_ID_1, ADMIN_1);
        repository.put(ADMIN_ID_2, ADMIN_2);
        repository.put(USER_ID_1, USER_1);
        repository.put(USER_ID_2, USER_2);
        repository.put(USER_ID_3, USER_3);
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(repository.values());
    }
}

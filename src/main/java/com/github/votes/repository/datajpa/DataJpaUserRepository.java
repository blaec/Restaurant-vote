package com.github.votes.repository.datajpa;

import com.github.votes.model.User;
import com.github.votes.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {
    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}

package com.github.votes.service.implementations;

import com.github.votes.model.User;
import com.github.votes.repository.UserRepository;
import com.github.votes.service.UserService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.votes.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }
}

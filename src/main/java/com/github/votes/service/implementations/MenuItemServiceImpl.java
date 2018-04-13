package com.github.votes.service.implementations;

import com.github.votes.model.MenuItem;
import com.github.votes.repository.MenuItemRepository;
import com.github.votes.service.MenuItemService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.votes.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository repository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public MenuItem get(int id) throws NotFoundException {
        return checkNotFoundWithId(repository.get(id), id);
    }

    @Override
    public List<MenuItem> getAll() {
        return repository.getAll();
    }

    @Override
    public List<MenuItem> getByRestaurant(int restaurantId) throws NotFoundException {
        return checkNotFoundWithId(repository.getByRestaurant(restaurantId), restaurantId);
    }

    @Override
    public MenuItem create(MenuItem menuItem) {
        return repository.save(menuItem);
    }

    @Override
    public MenuItem update(MenuItem menuItem) {
        return repository.save(menuItem);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }
}
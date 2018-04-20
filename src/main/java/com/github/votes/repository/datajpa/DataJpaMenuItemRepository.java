package com.github.votes.repository.datajpa;

import com.github.votes.model.MenuItem;
import com.github.votes.repository.MenuItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaMenuItemRepository implements MenuItemRepository {
    @Override
    public List<MenuItem> getByRestaurant(int restaurantId) {
        return null;
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public MenuItem get(int id) {
        return null;
    }

    @Override
    public List<MenuItem> getAll() {
        return null;
    }
}

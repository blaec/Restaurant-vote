package com.github.votes.repository.mock;

import com.github.votes.model.MenuItem;
import com.github.votes.repository.MenuItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMenuItemRepositoryImpl implements MenuItemRepository {

    private Map<Integer, MenuItem> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public List<MenuItem> getByRestaurant(int restaurantId) {
        return repository.values().stream()
                .filter(mi -> restaurantId == mi.getRestaurant().getId())
                .collect(Collectors.toList());
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        if (menuItem.isNew()) {
            menuItem.setId(counter.incrementAndGet());
            repository.put(menuItem.getId(), menuItem);
            return menuItem;
        }
        return repository.computeIfPresent(menuItem.getId(), (id, oldUser) -> menuItem);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id) != null;
    }

    @Override
    public MenuItem get(int id) {
        return repository.get(id);
    }

    @Override
    public List<MenuItem> getAll() {
        return new ArrayList<>(repository.values());
    }
}

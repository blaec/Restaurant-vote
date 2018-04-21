package com.github.votes.service.implementations;

import com.github.votes.model.MenuItem;
import com.github.votes.repository.MenuItemRepository;
import com.github.votes.service.MenuItemService;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    @Cacheable("menu_items")
    @Override
    public List<MenuItem> getAll() {
        return sortById(repository.getAll());
    }

    @Override
    public List<MenuItem> getByRestaurant(int restaurantId) throws NotFoundException {
        return checkNotFoundWithId(sortById(repository.getByRestaurant(restaurantId)), restaurantId);
    }

    @CacheEvict(value = "menu_items", allEntries = true)
    @Override
    public MenuItem create(MenuItem menuItem) {
        return repository.save(menuItem);
    }

    @CacheEvict(value = "menu_items", allEntries = true)
    @Override
    public MenuItem update(MenuItem menuItem) {
        return repository.save(menuItem);
    }

    @CacheEvict(value = "menu_items", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        checkNotFoundWithId(repository.delete(id), id);
    }

    private List<MenuItem> sortById(List<MenuItem> unsorted) {
        return unsorted.stream()
                .sorted(Comparator.comparing(MenuItem::getId))
                .collect(Collectors.toList());
    }
}

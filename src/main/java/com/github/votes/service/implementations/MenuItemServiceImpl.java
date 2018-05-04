package com.github.votes.service.implementations;

import com.github.votes.AuthorizedUser;
import com.github.votes.model.MenuItem;
import com.github.votes.repository.DishRepository;
import com.github.votes.repository.MenuItemRepository;
import com.github.votes.repository.RestaurantRepository;
import com.github.votes.service.MenuItemService;
import com.github.votes.to.MenuItemTo;
import com.github.votes.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.votes.model.Role.ROLE_ADMIN;
import static com.github.votes.util.ValidationUtil.*;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository repository;
    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository repository, DishRepository dishRepository, RestaurantRepository restaurantRepository) {
        this.repository = repository;
        this.dishRepository = dishRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public MenuItemTo get(int id) throws NotFoundException {
        MenuItem menuItem = checkNotFoundWithId(repository.get(id), id);
        String dishDescription = dishRepository.get(menuItem.getDish().getId()).getDescription();
        String restaurantName = restaurantRepository.get(menuItem.getRestaurant().getId()).getName();
        return new MenuItemTo(id, dishDescription, restaurantName);
    }

    @Cacheable("menu_items")
    @Override
    public List<MenuItem> getAll() {
        return sortById(repository.getAll());
    }

    @Override
    public List<MenuItem> getAllByDate(LocalDate date) throws NotFoundException {
        return checkNotFoundByDate(getAll().stream()
                    .filter(menuItem -> menuItem.getAdded().equals(date))
                    .collect(Collectors.toList()), date);
    }

    @Override
    public List<MenuItem> getByRestaurant(int restaurantId) throws NotFoundException {
        return checkNotFoundWithId(sortById(repository.getByRestaurant(restaurantId)), restaurantId);
    }

    @Override
    public List<MenuItem> getByRestaurantAndDate(int restaurantId, LocalDate date) throws NotFoundException {
        return checkNotFoundByDate(getByRestaurant(restaurantId).stream()
                    .filter(menuItem -> menuItem.getAdded().equals(date))
                    .collect(Collectors.toList()), date);
    }

    @CacheEvict(value = "menu_items", allEntries = true)
    @Override
    public MenuItem create(MenuItem menuItem) {
        checkRole(AuthorizedUser.getRole(), ROLE_ADMIN);
        return repository.save(menuItem);
    }

    @CacheEvict(value = "menu_items", allEntries = true)
    @Override
    public MenuItem update(MenuItem menuItem, int id) {
        assureIdConsistent(menuItem, id);
        checkRole(AuthorizedUser.getRole(), ROLE_ADMIN);
        return repository.save(menuItem);
    }

    @CacheEvict(value = "menu_items", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        checkRole(AuthorizedUser.getRole(), ROLE_ADMIN);
        checkNotFoundWithId(repository.delete(id), id);
    }

    private List<MenuItem> sortById(List<MenuItem> unsorted) {
        return unsorted.stream()
                .sorted(Comparator.comparing(MenuItem::getId))
                .collect(Collectors.toList());
    }
}

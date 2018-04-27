package com.github.votes.repository.mock;

import com.github.votes.model.MenuItem;
import com.github.votes.repository.MenuItemRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.github.votes.repository.mock_data.MenuItemTestData.*;

@Repository
public class InMemoryMenuItemRepositoryImpl implements MenuItemRepository {

    private Map<Integer, MenuItem> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    public void init(){
        repository.clear();
        repository.put(MENU_ITEM_ID_01, MENU_ITEM_01);
        repository.put(MENU_ITEM_ID_02, MENU_ITEM_02);
        repository.put(MENU_ITEM_ID_03, MENU_ITEM_03);
        repository.put(MENU_ITEM_ID_04, MENU_ITEM_04);
        repository.put(MENU_ITEM_ID_05, MENU_ITEM_05);
        repository.put(MENU_ITEM_ID_06, MENU_ITEM_06);
        repository.put(MENU_ITEM_ID_07, MENU_ITEM_07);
        repository.put(MENU_ITEM_ID_08, MENU_ITEM_08);
    }

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

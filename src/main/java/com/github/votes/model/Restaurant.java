package com.github.votes.model;

import java.util.List;

public class Restaurant extends AbstractNamedEntity {
    private List<Dish> lunchMenu;

    public Restaurant(int id, String name, List<Dish> lunchMenu) {
        super(id, name);
        this.lunchMenu = lunchMenu;
    }

    public List<Dish> getLunchMenu() {
        return lunchMenu;
    }

    public void setLunchMenu(List<Dish> lunchMenu) {
        this.lunchMenu = lunchMenu;
    }
}

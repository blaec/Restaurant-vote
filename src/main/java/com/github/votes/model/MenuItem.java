package com.github.votes.model;

import java.time.LocalDateTime;

public class MenuItem extends AbstractBaseEntity {
    private Dish dish;
    private Restaurant restaurant;
    private LocalDateTime added;

    public MenuItem(Integer id, Dish dish, Restaurant restaurant, LocalDateTime added) {
        super(id);
        this.dish = dish;
        this.restaurant = restaurant;
        this.added = added;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + super.getId() + '\'' +
                ", dish=" + dish +
                ", restaurant=" + restaurant +
                ", added=" + added +
                '}';
    }
}

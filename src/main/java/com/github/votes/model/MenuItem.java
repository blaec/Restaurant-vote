package com.github.votes.model;

import java.time.LocalDateTime;

public class MenuItem extends AbstactBaseEntiry {
    private User user;
    private Restaurant restaurant;
    private LocalDateTime added;

    public MenuItem(int id, User user, Restaurant restaurant, LocalDateTime added) {
        super(id);
        this.user = user;
        this.restaurant = restaurant;
        this.added = added;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}

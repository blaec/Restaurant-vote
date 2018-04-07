package com.github.votes.model;

import java.time.LocalDateTime;

public class Vote extends AbstactBaseEntiry {
    private Restaurant restaurant;
    private User user;
    private LocalDateTime taken;

    public Vote(int id, Restaurant restaurant, User user, LocalDateTime taken) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
        this.taken = taken;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTaken() {
        return taken;
    }

    public void setTaken(LocalDateTime taken) {
        this.taken = taken;
    }
}

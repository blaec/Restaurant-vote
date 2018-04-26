package com.github.votes.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "menu_items", uniqueConstraints = {@UniqueConstraint(columnNames = {"dish_id", "restaurant_id"}, name = "meal_item_unique_dish_and_restaurant_idx")})
public class MenuItem extends AbstractBaseEntity {

    @Column(name = "added", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime added;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dish dish;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public MenuItem() {}

    public MenuItem(Dish dish, Restaurant restaurant, LocalDateTime added) {
        this(null, dish, restaurant, added);
    }

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

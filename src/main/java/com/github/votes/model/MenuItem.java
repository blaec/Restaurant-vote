package com.github.votes.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu_items", uniqueConstraints = {@UniqueConstraint(columnNames = {"dish_id", "restaurant_id", "added"}, name = "meal_item_unique_dish_restaurant_added_idx")})
public class MenuItem extends AbstractBaseEntity {

    @Column(name = "added", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate added;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public MenuItem() {}

    public MenuItem(Dish dish, Restaurant restaurant, LocalDate added) {
        this(null, dish, restaurant, added);
    }

    public MenuItem(Integer id, Dish dish, Restaurant restaurant, LocalDate added) {
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

    public LocalDate getAdded() {
        return added;
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

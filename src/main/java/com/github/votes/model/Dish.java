package com.github.votes.model;

public class Dish extends AbstractBaseEntity {
    private String description;
    private int price;

    public Dish(int id, String description, int price) {
        super(id);
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id='" + super.getId() + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

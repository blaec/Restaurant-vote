package com.github.votes.model;

public class Restaurant extends AbstractNamedEntity {

    public Restaurant(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + super.getId() + '\'' +
                ", name=" + super.getName() +
                '}';
    }
}


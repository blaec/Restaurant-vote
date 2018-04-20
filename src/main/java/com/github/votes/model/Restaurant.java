package com.github.votes.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    public Restaurant() {}

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


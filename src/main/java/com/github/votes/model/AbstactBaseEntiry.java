package com.github.votes.model;

public abstract class AbstactBaseEntiry {
    private int id;

    public AbstactBaseEntiry(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

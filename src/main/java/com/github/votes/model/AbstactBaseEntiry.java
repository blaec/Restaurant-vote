package com.github.votes.model;

public abstract class AbstactBaseEntiry {

    public static final int START_SEQ = 100000;

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

package com.github.votes.model;

import java.util.List;

public class Restaurant extends AbstractNamedEntity {
    private int vote;

    public Restaurant(int id, String name, int vote) {
        super(id, name);
        this.vote = vote;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}

package com.github.votes.model;

import com.github.votes.to.HasId;

public abstract class AbstractBaseEntity implements HasId {
    public static final Integer START_SEQ = 100000;

    private Integer id;

    public AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

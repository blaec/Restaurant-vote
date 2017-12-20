package com.github.votes.model;

import java.util.Set;

public class User extends AbstractNamedEntity {
    private Set<Role> roles;

    public User(int id, String name, Set<Role> roles) {
        super(id, name);
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

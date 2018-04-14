package com.github.votes.model;

public class User extends AbstractNamedEntity {
    private Role roles;

    public User(int id, String name, Role roles) {
        super(id, name);
        this.roles = roles;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }
}

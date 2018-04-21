package com.github.votes.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity {

    @Enumerated(EnumType.STRING)
    @NotBlank
    @Column(name = "role", nullable = false)
    private Role role;

    protected User() {}

    public User(int id, String name, Role role) {
        super(id, name);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", role=" + role +
                '}';
    }
}

package com.github.votes;

import com.github.votes.model.AbstractBaseEntity;
import com.github.votes.model.Role;

import static com.github.votes.model.Role.ROLE_ADMIN;

/*
    With the registration, this class will be filled with data of authorized user: id and role.
*/
public class AuthorizedUser {

    private static int id = AbstractBaseEntity.START_SEQ + 2;

    private static Role role = ROLE_ADMIN;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }

    public static Role getRole() {
        return role;
    }

    public static void setRole(Role role) {
        AuthorizedUser.role = role;
    }
}

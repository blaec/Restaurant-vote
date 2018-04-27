package com.github.votes;

import com.github.votes.model.AbstractBaseEntity;
import com.github.votes.model.Role;

import static com.github.votes.model.Role.ROLE_ADMIN;

/*
    From simple logging page can be chosen user
*/
public class AuthorizedUser {

    private static int id = AbstractBaseEntity.START_SEQ;

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

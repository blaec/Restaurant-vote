package com.github.votes.repository.mock_data;

import com.github.votes.model.Role;
import com.github.votes.model.User;

import java.util.Arrays;
import java.util.List;

import static com.github.votes.model.AbstractBaseEntity.START_SEQ;

public class UserTestData {
    public static final int ADMIN_ID_1 = START_SEQ;
    public static final int ADMIN_ID_2 = START_SEQ + 1;
    public static final int USER_ID_1 = START_SEQ + 2;
    public static final int USER_ID_2 = START_SEQ + 3;
    public static final int USER_ID_3 = START_SEQ + 4;

    public static final User ADMIN_1 = new User(ADMIN_ID_1, "admin_1", Role.ROLE_ADMIN);
    public static final User ADMIN_2 = new User(ADMIN_ID_2, "admin_2", Role.ROLE_ADMIN);
    public static final User USER_1 = new User(USER_ID_1, "user_1", Role.ROLE_USER);
    public static final User USER_2 = new User(USER_ID_2, "user_2", Role.ROLE_USER);
    public static final User USER_3 = new User(USER_ID_3, "user_3", Role.ROLE_USER);

    public static final List<User> USERS = Arrays.asList(ADMIN_1, ADMIN_2, USER_1, USER_2, USER_3);
}

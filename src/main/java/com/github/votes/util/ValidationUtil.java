package com.github.votes.util;

import com.github.votes.model.MenuItem;
import com.github.votes.model.Role;
import com.github.votes.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ValidationUtil {
    private static LocalTime timeVoteLimit = LocalTime.of(11, 0);

    // for testing purposes only
    public static void setTimeVoteLimit(LocalTime timeVoteLimit) {
        ValidationUtil.timeVoteLimit = timeVoteLimit;
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id=" + id);
    }

    public static <T> T checkNotFoundWithId(T object, int id) {
        return checkNotFound(object, "id=" + id);
    }

    public static <T> List<T> checkNotFoundWithId(List<T> list, int id) {
        return checkNotFound(list, "id=" + id);
    }

    public static void checkRole(Role actual, Role expected) {
        if (actual != expected) {
            throw new NotFoundException(String.format("Only user with role %s is allowed to modify data.", expected));
        }
    }

    public static void checkVoteTimeLimit(LocalDateTime taken) {
        if (taken.toLocalTime().isAfter(timeVoteLimit)) {
            throw new NotFoundException(String.format("You are allowed to vote until: %s", timeVoteLimit));
        }
    }

    public static void assureIdConsistent(MenuItem menuItem, int id) {
        if (menuItem.getId() != id) {
            throw new NotFoundException(String.format("%s must be with id=%d", menuItem, id));
        }
    }

    private static <T> T checkNotFound(T object, String msg) {
        checkNotFound(object != null, msg);
        return object;
    }

    private static <T> List<T> checkNotFound(List<T> list, String msg) {
        checkNotFound(!list.isEmpty(), msg);
        return list;
    }

    private static void checkNotFound(boolean found, String msg) {
        if (!found) {
            throw new NotFoundException("Not found entity with " + msg);
        }
    }
}

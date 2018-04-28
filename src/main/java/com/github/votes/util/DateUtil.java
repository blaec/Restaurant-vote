package com.github.votes.util;

import java.time.LocalDate;

public class DateUtil {
    public static LocalDate getDefault(LocalDate date) {
        return date != null ? date : LocalDate.now();
    }
}

package com.example.demoauth.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateTimeUtil {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public LocalDateTime toLocalDateTime(String dateTime) {
        return LocalDateTime.parse(dateTime, formatter);
    }
}

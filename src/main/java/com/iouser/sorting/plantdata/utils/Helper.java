package com.iouser.sorting.plantdata.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class Helper {
    public static PasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
    public Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    public static ZoneId defaultZoneId = TimeZone.getDefault().toZoneId();
    public static Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
    public static LocalDateTime timeStampToLocalDateTime(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), defaultZoneId);
    }

    public static String findLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}

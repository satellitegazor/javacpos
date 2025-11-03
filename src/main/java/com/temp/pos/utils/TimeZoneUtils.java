package com.temp.pos.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneUtils {
    /**
     * Returns the number of minutes the system's default timezone is offset from American Central Time (America/Chicago).
     * Positive values mean the system timezone is ahead of Central Time; negative values mean it is behind.
     *
     * @return The offset in minutes from Central Time.
     */
    public static int getSystemTimezoneOffsetFromCentralTime() {
        // Define Central Time timezone
        ZoneId centralTimeZone = ZoneId.of("America/Chicago");
        // Get system's default timezone
        ZoneId systemZone = ZoneId.systemDefault();
        
        // Get current time in both timezones
        ZonedDateTime centralTime = ZonedDateTime.now(centralTimeZone);
        ZonedDateTime systemTime = ZonedDateTime.now(systemZone);
        
        // Get offsets in seconds and convert to minutes
        int centralOffsetMinutes = centralTime.getOffset().getTotalSeconds() / 60;
        int systemOffsetMinutes = systemTime.getOffset().getTotalSeconds() / 60;
        
        // Return the difference (system - Central)
        return systemOffsetMinutes - centralOffsetMinutes;
    }
    
   public static String getTodayBusinessDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return today.format(formatter);
    }
}
/*
Name:         DateTime.java
Author:       Alex Yuan
Date:         Jan 18, 2020
Purpose:      This class is responsible for representing the
              date and time which is used in many parts of the
              project.
*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    int year;
    int month;
    int day;
    int hour;
    int min;

    // Allows the user to construct the DateTime object with varibles.
    public DateTime(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Allows the user to construct the DateTime object with a string.
    public DateTime(String date_string) {
        String[] split_date = date_string.split("/");
        this.month = Integer.parseInt(split_date[0]);
        this.day = Integer.parseInt(split_date[1]);
        this.year = Integer.parseInt(split_date[2]);
    }

    public DateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        String temp[] = formattedDate.split("-");
    }

    public DateTime(int year, int month, int day, int hour, int min) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
    }

    // Allows the verification of a valid date entered with varibles.
    public static boolean verifyDate(int month, int day, int year) {
        return (month <= 12 && month >= 1) && (day <= 31 && day >= 1) && (year >= 0);
    }

    // Allows the user to compare another DateTime object.
    public int compareTo(DateTime other) {
        if (this.year == other.year) {
            if (this.month == other.month)
                return this.day - other.day;
            else
                return this.month - other.month;
        } else
            return this.year - other.year;
    }

    // Allows the verification of a valid date entered with the DateTime object.
    public static boolean verifyDate(DateTime dateTime) {
        return (dateTime.getMonth() <= 12 && dateTime.getMonth() >= 1)
                && (dateTime.getDay() <= 31 && dateTime.getDay() >= 1) && (dateTime.getYear() >= 0);
    }

    public String toString() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    // ********** GETTERS AND SETTERS **********
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

}

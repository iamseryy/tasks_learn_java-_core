package ru.task1.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public record Note(String note, Calendar date) {
    @Override
    public String toString() {
        var dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(date.getTime()) + " -> " + note;
    }
}

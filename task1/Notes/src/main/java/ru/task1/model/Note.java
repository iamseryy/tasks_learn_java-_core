package ru.task1.model;

import java.util.Calendar;

public record Note(String note, Calendar date) {
    @Override
    public String toString() {
        return "Note{" +
                "note='" + note + '\'' +
                ", date=" + date +
                '}';
    }
}

package ru.task1.repository.impl;

import ru.task1.model.Note;
import ru.task1.repository.Notes;

import java.util.ArrayList;
import java.util.HashSet;

public class NotesImpl implements Notes {



    @Override
    public void add(Note note) {

    }

    @Override
    public HashSet<Note> findAll() {
        return null;
    }

    private static HashSet<Note> initCollection() {
        var notes = new HashSet<Note>();

        ArrayList<String> data = FileUtils.readFiles(AppConfig.getPath("path.database"));

        for (String line: data) {
            String[] values = line.split("><");
            people.add(new Person(values[1], values[0].replace("<", ""), values[2],
                    values[3].replace(">", "")));
        }

        return notes;
    }
}

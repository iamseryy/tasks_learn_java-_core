package ru.task1.repository.impl;

import ru.task1.model.Note;
import ru.task1.repository.Notes;
import ru.task1.util.FIleUtils;
import ru.task1.config.AppConfig;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class NotesImpl implements Notes {
    private static HashSet<Note> notes = initCollection();

    private NotesImpl(){}

    private static NotesImpl instance;

    public static NotesImpl getInstance(){
        if(instance == null){
            instance = new NotesImpl();
        }
        return instance;
    }

    @Override
    public void add(Note note) {
        notes.add(note);
        FIleUtils.writeCsv(new File(noteData), note, StandardCharsets.UTF_8);

    }

    @Override
    public HashSet<Note> findAll() {
        return notes;
    }

    private static HashSet<Note> initCollection() {
        return FIleUtils.readCsv(new File(noteData), StandardCharsets.UTF_8);
    }
}

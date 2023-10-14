package ru.task1.service.impl;

import ru.task1.model.Note;
import ru.task1.repository.Notes;
import ru.task1.repository.impl.NotesImpl;
import ru.task1.service.NoteService;
import java.util.HashSet;

public class NoteServiceImpl implements NoteService {
    private static Notes notes = NotesImpl.getInstance();
    @Override
    public void add(Note note) {
        notes.add(note);
    }

    @Override
    public HashSet<Note> findAll() {
        return notes.findAll();
    }
}

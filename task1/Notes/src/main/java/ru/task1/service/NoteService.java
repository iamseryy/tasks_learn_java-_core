package ru.task1.service;

import ru.task1.model.Note;
import java.util.HashSet;

public interface NoteService {
    void add(Note note);
    HashSet<Note> findAll();
}

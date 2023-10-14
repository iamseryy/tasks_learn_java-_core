package ru.task1.view.template;

import ru.task1.service.NoteService;
import ru.task1.service.impl.NoteServiceImpl;

public interface Template<T> {
    void output();
    NoteService registryService = new NoteServiceImpl();
}
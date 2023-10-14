package ru.task1.view.template;

import ru.task1.service.NoteService;
import ru.task1.service.impl.NoteServiceImpl;
import ru.task1.view.ui.UserInterface;
import ru.task1.view.ui.impl.UserInterfaceImpl;

public interface Template<T> {
    void output();
    NoteService noteService = new NoteServiceImpl();
    UserInterface ui = UserInterfaceImpl.getInstance();
}
package ru.task1.view.template.impl;

import ru.task1.view.template.Template;

public class DisplayAllNotesTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nDisplay all notes\n");
        var notes = noteService.findAll();
        if(notes.isEmpty()){
            ui.output("\nNo notes\n");
            ui.pressEnterToContinue();
            return;
        }

        notes.stream()
                .sorted((note1, note2) -> note1.date().compareTo(note2.date()))
                .forEach(note -> System.out.println(note.toString()));

        ui.pressEnterToContinue();
    }
}

package ru.task1.view.template.impl;

import ru.task1.model.Note;
import ru.task1.view.template.Template;

import java.util.Calendar;
import java.util.Optional;

public class AddNoteTemplate implements Template {
    @Override
    public void output() {
        ui.output("\nAdd note\n");
        Optional<String> note = ui.input("Enter the note or enter an empty string to cancel: ", String::toString);
        if(note.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        noteService.add(new Note(note.get(), Calendar.getInstance()));
        ui.output("\nNote added");
        ui.pressEnterToContinue();
    }
}

package ru.task1.view.menu;


import ru.task1.view.template.impl.AddNoteTemplate;
import ru.task1.view.template.impl.ExitTemplate;
import ru.task1.view.template.impl.PrintAllNotesTemplate;
import java.util.Arrays;
import java.util.List;

public interface GeneralMenu {
    String header = "\nNotes\n";
    List<MenuItem> generalMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Print all notes", () -> new PrintAllNotesTemplate().output()),
                    new MenuItem("2 Add note", () -> new AddNoteTemplate().output()),
                    new MenuItem("3 Exit", () -> new ExitTemplate().output())
            }
    );
}

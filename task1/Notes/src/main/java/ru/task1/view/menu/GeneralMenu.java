package ru.task1.view.menu;


import java.util.Arrays;
import java.util.List;

public interface GeneralMenu {
    String header = "\nPet registry\n";
    List<MenuItem> generalMenuItems = Arrays.asList(
            new MenuItem[] {
                    new MenuItem("1 Print all notes", () -> new PrintAllNotesTemplate().output()),
                    new MenuItem("2 Add note", () -> new AddNoteTemplate().output()),
                    new MenuItem("4 Exit", () -> new ExitTemplate().output())
            }
    );
}

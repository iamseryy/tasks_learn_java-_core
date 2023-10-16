package ru.task1.view.menu.impl;

import ru.task1.view.menu.GeneralMenu;
import ru.task1.view.menu.Menu;

public class GeneralMenuImpl extends Menu implements GeneralMenu {
    public void processing() {
        super.processing(header, generalMenuItems);
    }
}
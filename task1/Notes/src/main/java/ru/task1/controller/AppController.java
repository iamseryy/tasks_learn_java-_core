package ru.task1.controller;

import ru.task1.view.menu.impl.GeneralMenuImpl;

public class AppController {
    public static void start(){
        new GeneralMenuImpl().processing();
    }
}

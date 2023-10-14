package ru.task1.view.template.impl;

import ru.task1.config.AppConfig;
import ru.task1.view.template.Template;

import java.util.logging.Level;

public class ExitTemplate implements Template {
    @Override
    public void output() {
        AppConfig.LOGGER.log(Level.INFO, "Application closed");
    }
}

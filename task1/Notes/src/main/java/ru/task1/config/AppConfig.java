package ru.task1.config;

import ru.task1.NotesApp;
import ru.task1.controller.AppController;
import ru.task1.util.FIleUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppConfig {

    public static final Logger LOGGER = Logger.getLogger(AppController.class.getName());
    private static final String CONFIG_PROPERTIES = "config.properties";

    public String getProperty(String key) {
        var property = new Properties();
        var fileUtils = new FIleUtils();
        try(var inputStream = fileUtils.getFileFromResourceAsStream(CONFIG_PROPERTIES);){
            property.load(inputStream);

        } catch (IOException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        return property.getProperty(key);
    }
}


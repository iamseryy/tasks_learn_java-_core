package ru.task1.view.template.impl;

import org.gbtask.config.AppConfig;
import org.gbtask.exception.DataBaseException;
import org.gbtask.exception.PetRegistryException;
import org.gbtask.model.Cat;
import org.gbtask.view.template.Template;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.logging.Level;

public class AddCatTemplate  implements Template {
    @Override
    public void output() {
        ui.output("\nAdd a cat\n");
        ui.output("Complete the following fields or enter an empty string to cancel\n");

        Optional<String> name = ui.input("Name: ", String::toString);
        if(name.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<Integer> height = ui.input("Height: ", Integer::parseInt);
        if(height.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<Integer> weight = ui.input("Weight: ", Integer::parseInt);
        if(weight.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Optional<Date> birthDateOpt =  ui.input("Birth Date (dd-mm-yyyy): ", sdf::parse);
        if (birthDateOpt.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(birthDateOpt.get());

        Optional<String> breed = ui.input("Breed: ", String::toString);
        if(breed.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<Boolean> isVaccinated = ui.input("Is Vaccinated (true or false): ", Boolean::parseBoolean);
        if(isVaccinated.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<Integer> mustacheLength = ui.input("Mustache length: ", Integer::parseInt);
        if(mustacheLength.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        Optional<String> note = ui.input("Note: ", String::toString);
        if(breed.isEmpty()){
            ui.output("\nCancelled\n");
            return;
        }

        var commands = new HashSet<String>();
        Optional<Integer> choice;
        while (true) {
            choice = ui.input("Does the animal know commands? (1 yes/ 2 no)?: ", Integer::parseInt);
            if (choice.isEmpty() || choice.get() < 1 || choice.get() > 2) {
                ui.output("Invalid input data! Try Again");
                continue;
            }

            if(choice.get() == 1){
                commands = getCommands();
            }

            break;
        }

        Cat cat = new Cat(height.get(), weight.get(), birthDate, name.get(), breed.get(), commands,
                isVaccinated.get(), mustacheLength.get());

        try {
            ui.output("Added registry entry: " + registryService.add(cat, note.get()));
        } catch (DataBaseException e) {
            AppConfig.LOGGER.log(Level.SEVERE, e.toString(), e);
            ui.output(e.toString());
        }

        ui.pressEnterToContinue();
    }

    private static HashSet<String> getCommands(){
        var commands = new HashSet<String>();

        while (true){
            Optional<String> command =  ui.input("Command: ", String::toString);
            if(command.isEmpty()){
                ui.output("\nCancelled\n");
                commands.clear();
                return commands;
            }

            commands.add(command.get());

            Optional<Integer> choice;
            while (true) {
                choice = ui.input("Does the animal know another command?? (1 yes/ 2 no)?: ", Integer::parseInt);
                if (choice.isEmpty() || choice.get() < 1 || choice.get() > 2) {
                    ui.output("Invalid input data! Try Again");
                    continue;
                }

                if(choice.get() == 2){
                    return commands;
                }

                break;
            }
        }
    }
}

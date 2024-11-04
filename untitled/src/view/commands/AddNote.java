package view.commands;

import view.ConsoleUI;

public class AddNote extends Command{
    public AddNote(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создать запись";
    }

    @Override
    public void execute() {
        consoleUI.addNote();
    }
}

package view.commands;

import view.ConsoleUI;

public class ClearFile extends Command{
    public ClearFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Очистить список задач";
    }

    @Override
    public void execute() {
        consoleUI.clearFile();
    }
}

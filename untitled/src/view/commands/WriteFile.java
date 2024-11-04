package view.commands;

import view.ConsoleUI;

public class WriteFile extends Command{

    public WriteFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    @Override
    public void execute() {
        consoleUI.writeFile();
    }
}

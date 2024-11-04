package view.commands;

import view.ConsoleUI;

public class FindByDate extends Command{

    public FindByDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать задачи на день";
    }

    @Override
    public void execute() {
        consoleUI.findByDate();
    }
}

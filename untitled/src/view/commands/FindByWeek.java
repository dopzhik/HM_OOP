package view.commands;

import view.ConsoleUI;

public class FindByWeek extends Command{
    public FindByWeek(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать задачи на неделю";
    }

    @Override
    public void execute() {
        consoleUI.findByWeek();
    }
}

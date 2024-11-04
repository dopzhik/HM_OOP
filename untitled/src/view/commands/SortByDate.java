package view.commands;

import view.ConsoleUI;

public class SortByDate extends Command{

    public SortByDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по дате";
    }

    @Override
    public void execute() {
        consoleUI.sortByDate();
    }
}

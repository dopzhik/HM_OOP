package view.commands;

import model.note.Note;
import view.ConsoleUI;

import java.util.List;

public class GetNotebookInfo extends Command {
    public GetNotebookInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать весь список задач";
    }

    @Override
    public void execute() {
        consoleUI.getNotebookInfo();
    }
}

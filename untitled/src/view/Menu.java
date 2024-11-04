package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddNote(consoleUI));
        commandList.add(new GetNotebookInfo(consoleUI));
        commandList.add(new SortByDate(consoleUI));
        commandList.add(new FindByDate(consoleUI));
        commandList.add(new FindByWeek(consoleUI));
        commandList.add(new WriteFile(consoleUI));
        commandList.add(new ClearFile(consoleUI));
        commandList.add(new Finish(consoleUI));

    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i <commandList.size(); i++) {
            stringBuilder.append(i + 1).
                    append(". ").
                    append(commandList.get(i).getDescription()).
                    append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        commandList.get(choice-1).execute();
    }

    protected int getSize(){
        return commandList.size();
    }
}

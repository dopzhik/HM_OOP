import model.note.Note;
import model.notebook.Notebook;
import model.notebook.NotebookService;
import view.ConsoleUI;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {


//        NotebookService notebookService = new NotebookService();
//
//        notebookService.addNote(LocalDateTime.parse("24-03-2024:20:20"), "opra");
//        notebookService.writeFile();
//        Notebook file = notebookService.readFile();
//        for (Note note : file) {
//        System.out.println(note);}
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();
    }
}
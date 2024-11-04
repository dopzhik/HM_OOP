package model.note;

import model.notebook.Notebook;
import view.ConsoleUI;

import java.time.LocalDateTime;

public class NoteService {

    public Note createNote(LocalDateTime date, String task) {
        int id = Notebook.notebook.size() + 1;
        return new Note(id++, date, task);
    }
}

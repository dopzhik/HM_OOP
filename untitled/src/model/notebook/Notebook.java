package model.notebook;

import model.note.Note;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notebook implements Iterable<Note>, Serializable {
    public static List<Note> notebook = new ArrayList<>();
    NotebookService service = new NotebookService();

    public Notebook() {
        notebook = new ArrayList<>();
        notebook.addAll(service.readFile());
    }

    @Override
    public Iterator<Note> iterator() {
        return new NotebookIterator(notebook);
    }
}

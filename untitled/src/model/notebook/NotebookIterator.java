package model.notebook;

import model.note.Note;

import java.util.Iterator;
import java.util.List;

public class NotebookIterator implements Iterator<Note> {

    private int index;
    private final List<Note> list;

    public NotebookIterator(List<Note> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Note next() {
        return list.get(index++);
    }
}

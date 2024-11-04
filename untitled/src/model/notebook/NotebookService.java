package model.notebook;

import model.note.Note;
import model.note.NoteService;
import model.notebook.comparators.CompareNotebookByDate;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class NotebookService {
    private final NoteService noteService;
    String path = "db.data";

    public NotebookService() {
        noteService = new NoteService();
    }

    public void addNote(LocalDateTime date, String task) {
        Note note = noteService.createNote(date, task);
        Notebook.notebook.add(note);
    }

    public void sortByDate() {
        Notebook.notebook.sort(new CompareNotebookByDate());
    }

    public String getNotebookInfo() {
        if (Notebook.notebook.isEmpty()) return "Список задач пуст\n";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список задач: \n");
        for (Note note : Notebook.notebook) {
            stringBuilder.append(note).append('\n');
        }
        return stringBuilder.toString();
    }

    public List<Note> findByDate(LocalDateTime date) {
        List<Note> noteDay = new ArrayList<>();
        for (Note note : Notebook.notebook) {
            if (note.getDate().getYear() == date.getYear() &&
                    note.getDate().getMonth() == date.getMonth() &&
                    note.getDate().getDayOfMonth() == date.getDayOfMonth()) {
                noteDay.add(note);
            }
        }
        return noteDay;
    }

    public List<Note> findByWeeK(LocalDateTime weekFirstDay) {
        List<Note> noteDay = new ArrayList<>();
        LocalDateTime weekLastDay = weekFirstDay.plusWeeks(1);
        for (Note note : Notebook.notebook) {
            if (note.getDate().isAfter(weekFirstDay) &&
                    note.getDate().isBefore(weekLastDay)) {
                noteDay.add(note);
            }
        }
        return noteDay;
    }

    public void writeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(Notebook.notebook);
            System.out.println("Данные сохранены");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void clearFile() {
        Notebook.notebook = new ArrayList<>();
        writeFile();
    }

    public List<Note> readFile() {
        Object notebook = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            notebook = ois.readObject();
            System.out.println("Данные загружены");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (List<Note>) notebook;

    }


}

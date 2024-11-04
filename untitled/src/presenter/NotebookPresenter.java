package presenter;

import model.note.Note;
import model.notebook.NotebookService;
import view.NotebookView;

import java.time.LocalDateTime;
import java.util.List;

public class NotebookPresenter {
    private final NotebookService service;
    private final NotebookView view;

    public NotebookPresenter(NotebookView consoleView) {
        service = new NotebookService();
        view = consoleView;
    }

    public void sortByDate() {
        service.sortByDate();
    }

    public void addNote(LocalDateTime date, String task) {
        service.addNote(date, task);
    }


    public String getNotebookInfo() {
        return service.getNotebookInfo();
    }

    public List<Note> findByDate(LocalDateTime date) {
        return service.findByDate(date);
    }

    public List<Note> findByWeek(LocalDateTime date) {
        return service.findByWeeK(date);
    }


    public void writeFile() {
        service.writeFile();
    }

    public void clearFile() {
        service.clearFile();
    }

    public List<Note> readFile() {
        return service.readFile();
    }
}

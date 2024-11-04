package model.note;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.time.LocalDateTime;
import java.util.Objects;

public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private LocalDateTime date;
    private String task;
    private static DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy, в HH часов mm минут");

    public Note(int id, LocalDateTime date, String task) {
        this.id = id;
        this.date = date;
        this.task = task;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Задача № %d: %s , %s", id, task, date.format(formatter));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && Objects.equals(date, note.date) && Objects.equals(task, note.task);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, task);
    }
}

package model.notebook.comparators;

import model.note.Note;

import java.util.Comparator;
import java.util.Date;

public class CompareNotebookByDate implements Comparator<Note> {

    @Override
    public int compare(Note o2, Note o1) {
        int cmp = Integer.compare(o2.getDate().getYear(), o1.getDate().getYear());
        if (cmp == 0) {
            cmp = Integer.compare(o2.getDate().getMonthValue(), o1.getDate().getMonthValue());
            if (cmp == 0) {
                cmp = Integer.compare(o2.getDate().getDayOfMonth(), o1.getDate().getDayOfMonth());
                if (cmp == 0) {
                    cmp = Integer.compare(o2.getDate().getHour(), o1.getDate().getHour());
                    if (cmp == 0) {
                        cmp = Integer.compare(o2.getDate().getMinute(), o1.getDate().getMinute());
                    }
                }
            }
        }
        return cmp;
    }
}

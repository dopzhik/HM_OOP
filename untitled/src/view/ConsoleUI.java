package view;

import presenter.NotebookPresenter;
import model.note.Note;
import model.notebook.Notebook;
import model.notebook.NotebookService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements NotebookView {

    private Scanner scanner;
    private NotebookService notebookService;
    private Menu menu;
    private NotebookPresenter notebookPresenter;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH-mm");
    private DateTimeFormatter formatDay = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        notebookService = new NotebookService();
        notebookPresenter = new NotebookPresenter(this);
        menu = new Menu(this);
    }

    @Override
    public void start() {
        readFile();
        while (true) {
            System.out.println("Добрый день, выберите одно из действий");
            System.out.println(menu.menu());
            execute();

        }
    }

    public void addNote() {
        String dateString;
        String timeString;
        System.out.println("Введите задачу: ");
        String task = scanner.nextLine();


        while (true) {
            try {
                System.out.println("Введите дату в формате 'dd-mm-yyyy': ");
                dateString = checkDate(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Введите время в формате 'HH-mm': ");
                timeString = checkTime(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        LocalDateTime date = LocalDateTime.parse(dateString + ":" + timeString, dtf);
        notebookPresenter.addNote(date, task);
    }

    public void sortByDate() {
        notebookPresenter.sortByDate();
    }

    public void getNotebookInfo() {
        System.out.println(notebookPresenter.getNotebookInfo());
    }

    public void findByDate() {
        String dateString;
        while (true) {
            try {
                System.out.println("Введите дату для поиска в формате 'dd-mm-yyyy': ");
                dateString = checkDate(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        LocalDateTime noteDay = LocalDateTime.parse(dateString + ":00-00", dtf);
        List<Note> notebookDay = notebookPresenter.findByDate(noteDay);
        System.out.printf("Cписок задач на дату %s: ", noteDay.format(formatDay));
        if (notebookDay.isEmpty()) {
            System.out.print("пуст\n\n");
        } else {
            System.out.println(" ");
            for (Note note : notebookDay) {
                System.out.println(note);
            }
            System.out.println(" ");
        }
    }

    public void findByWeek() {
        String dateString;
        while (true) {
            try {
                System.out.println("Введите первый день недели для поиска в формате 'dd-mm-yyyy': ");
                dateString = checkDate(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        LocalDateTime noteDay = LocalDateTime.parse(dateString + ":00-00", dtf);
        List<Note> notebookDay = notebookPresenter.findByWeek(noteDay);
        System.out.printf("Cписок задач на даты с %s по %s: ", noteDay.format(formatDay), noteDay.plusWeeks(1).format(formatDay));
        if (notebookDay.isEmpty()) {
            System.out.print("пуст\n\n");
        } else {
            System.out.println(" ");
            for (Note note : notebookDay) {
                System.out.println(note);
            }
            System.out.println(" ");
        }
    }

    public void finish() {
        System.exit(0);
    }

    public void readFile() {
        Notebook.notebook.addAll(notebookPresenter.readFile());
    }

    public void writeFile() {
        notebookPresenter.writeFile();
    }

    public void clearFile() {
        notebookPresenter.clearFile();
    }

    private void execute() {
        String command = scanner.nextLine();
        if (checkTextForInt(command)) {
            int intCommand = Integer.parseInt(command);
            if (checkMenuChoice(intCommand)) {
                menu.execute(intCommand);
            } else System.out.printf("Введите число от 1 до %d\n", menu.getSize());
        } else System.out.println("Введите число! \n");
    }

    private boolean checkTextForInt(String text) {
        return text.matches("[0-9]+");
    }

    private boolean checkMenuChoice(int choice) {
        return choice <= menu.getSize();
    }

    private String checkDate(String dateString) {
        String[] split = dateString.split("-");
        if (split.length != 3)
            throw new RuntimeException("Введен неверный формат даты");
        int year = Integer.parseInt(split[2]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[0]);
        if (year < 1 || year > 9999) {
            throw new RuntimeException("год: " + year + " вне диапозона 0001-9999");
        }

        if (month < 1 || month > 12) {
            throw new RuntimeException("месяц: '" + month + "' вне диапозона 01-12");
        }
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 12};
        if (month == 2 && isLeapYear(year)) {
            months[1] = 29;
        }
        if (day < 1 || day > months[month - 1]) {
            throw new RuntimeException("день месяца: '" + day + "' вне диапозона 01-" + months[month - 1]);
        }
        return dateString;
    }

    private String checkTime(String timeString) {
        String[] split = timeString.split("-");
        if (split.length != 2)
            throw new RuntimeException("Введен неверный формат времени");
        int minute = Integer.parseInt(split[1]);
        int hour = Integer.parseInt(split[0]);
        if (hour < 0 || hour > 23) {
            throw new RuntimeException("час: " + hour + " вне диапозона 00-23");
        }
        if (minute < 0 || minute > 59) {
            throw new RuntimeException("минута: " + minute + " вне диапозона 00-59");
        }
        return timeString;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}

package Entity;

import java.time.LocalDate;

public class Event {
    private int id;
    private String name;
    private String prize;

    private LocalDate date;

    public Event(int id, String name, String prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getPrize() {
        return prize;
    }

    public LocalDate getDate() {
        return date;
    }
}

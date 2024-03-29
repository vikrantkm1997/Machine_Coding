package Entity;

public class BookingTimeSlot {
    private int docId;
    private int startTime;
    private int endTime;

    private Boolean isBooked;

    public BookingTimeSlot(int docId, int startTime, int endTime) {
        this.docId = docId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = false;
    }

    public Boolean setBooked(Boolean booked) {
        isBooked = booked;
        return booked;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public Boolean getBooked() {
        return isBooked;
    }
}

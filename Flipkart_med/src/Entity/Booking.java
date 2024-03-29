package Entity;

public class Booking {
    private int bookingId;
    private int docId;
    private int patientId;
    private int startTime;
    private int endTime;

    public int getBookingId() {
        return bookingId;
    }

    public Booking(int bookingId, int docId, int patientId, int startTime, int endTime) {
        this.bookingId = bookingId;
        this.docId = docId;
        this.patientId = patientId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDocId() {
        return docId;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}

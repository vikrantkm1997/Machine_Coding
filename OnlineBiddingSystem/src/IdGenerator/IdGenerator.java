package IdGenerator;

public class IdGenerator {
    private static int userId;
    private static int eventId;

    private static int bidId;

    public IdGenerator() {
        userId = 0;
        eventId = 0;
        bidId = 0;
    }

    public static int getUserId() {
        return ++userId;
    }

    public static int getEventId() {
        return ++eventId;
    }

    public static int getBidId() {
        return ++bidId;
    }


}

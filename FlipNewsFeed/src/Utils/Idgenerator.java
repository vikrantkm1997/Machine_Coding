package Utils;

public class Idgenerator {
    public static int userId = 1;
    public static int feedId = 1;

    public static int getUserId() {
        return userId++;
    }

    public static int getFeedId() {
        return feedId++;
    }
}

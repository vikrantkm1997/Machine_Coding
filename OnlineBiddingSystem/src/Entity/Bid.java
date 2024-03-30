package Entity;

public class Bid {
    private int id;
    private int userId;
    private int minBin;
    private int maxBid;

    public Bid(int id, int userId, int minBin, int maxBid) {
        this.id = id;
        this.userId = userId;
        this.minBin = minBin;
        this.maxBid = maxBid;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getMinBin() {
        return minBin;
    }

    public int getMaxBid() {
        return maxBid;
    }
}

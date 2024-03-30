package Entity;

public class User {
    int id;
    String userName;
    int superCoins;

    public User(int id, String userName, int superCoins) {
        this.id = id;
        this.userName = userName;
        this.superCoins = superCoins;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public int updateCoins(int coins) {
        this.superCoins -= coins;
        return this.superCoins;
    }

    public String getUserName() {
        return userName;
    }
}

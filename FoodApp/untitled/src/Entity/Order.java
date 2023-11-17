package Entity;

public class Order {
    String foodName;
    User user;
    Restaurant restaurant;

    public Order(String foodName, User user, Restaurant restaurant) {
        this.foodName = foodName;
        this.user = user;
        this.restaurant = restaurant;
    }
}

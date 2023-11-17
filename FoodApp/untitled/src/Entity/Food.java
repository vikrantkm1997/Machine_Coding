package Entity;

public class Food {
    String foodName;
    int quantity;
    int price;

    public Food(String foodName, int quantity, int price) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }

    public int getPrice()
    {
        return this.price;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public String getFoodName()
    {
        return this.foodName;
    }
}

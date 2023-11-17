package Entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    String name;
    Food food;
    List<String> cities;
    List<Review> reviews;

    Double ratingSum;
    Double rating;

    public Restaurant(String name, String cities, String foodName,int foodPrice,int quantity) {
        this.name = name;
        this.food = new Food(foodName,quantity,foodPrice);
        this.cities = Arrays.stream(cities.split("/")).toList();
        this.reviews = new ArrayList<>();
        this.ratingSum = 0.0;
    }

    public void createReview(int ratingByUser,String comment)
    {
        reviews.add(new Review(ratingByUser,comment));
        this.ratingSum += ratingByUser;
        this.rating = ratingSum/ reviews.size();
    }

    public String getName() {
        return name;
    }

    public Food getFood() {
        return food;
    }

    public void updateQuantity(int quantity)
    {
        food.updateQuantity(quantity);
    }

    public Double getRating() {
        return rating;
    }

    public Boolean placeOrder(int quantity)
    {
        if(quantity > this.getFood().getQuantity())
            return false;
        else
        {
            this.getFood().updateQuantity(-quantity);
            return true;
        }
    }
}

import Entity.Order;
import Entity.Restaurant;
import Entity.User;
import Strategy.Strategy;
import Strategy.PriceStrategy;
import Strategy.RatingStrategy;

import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodKartApp {
    Map<String, Restaurant> restaurantMap;
    Map<String, List<Restaurant>> cityRestaurantMap;
    Map<String, User> userMap;
    User loggedInUser;

    public FoodKartApp()
    {
        this.restaurantMap = new HashMap<>();
        this.cityRestaurantMap = new HashMap<>();
        this.userMap = new HashMap<>();
    }

    public void registerUser(String userName,String gender,String phoneNo,String location)
    {
        User user = new User(userName,gender,phoneNo,location);
        userMap.put(phoneNo,user);
    }

    public Boolean userLogin(String phoneNo)
    {
        if(userMap.containsKey(phoneNo))
        {
            this.loggedInUser = userMap.get(phoneNo);
            return true;
        }
        return false;
    }

    public void registerRestaurant(String name,String location,String foodName,int price, int quantity)
    {
        Restaurant restaurant = new Restaurant(name,location,foodName,price,quantity);
        restaurantMap.put(name,restaurant);

        String []cities = location.split("/");
        for(String city:cities)
        {
            if(cityRestaurantMap.containsKey(city))
            {
                cityRestaurantMap.get(city).add(restaurant);
            }
            else
            {
                cityRestaurantMap.put(city,new ArrayList<>());
                cityRestaurantMap.get(city).add(restaurant);
            }
        }
    }

    public void updateQuantity(String restaurantName,int quantity)
    {
        if(restaurantMap.containsKey(restaurantName))
        {
            Restaurant restaurant = restaurantMap.get(restaurantName);
            restaurant.updateQuantity(quantity);
            System.out.println(restaurant.getName()+ " "+ restaurant.getFood().getFoodName()+" "+restaurant.getFood().getQuantity());
        }
        else {
            System.out.println("No restaurant FOUND " + restaurantName);
        }
    }

    public List<Restaurant> showRestaurant(String type)
    {
        List<Restaurant> restaurants;
        String location = loggedInUser.getLocation();
        Strategy strategy;
        restaurants = cityRestaurantMap.get(location);
//        for(Map.Entry<String,Restaurant> entry:restaurantMap.entrySet())
//        {
//            restaurants.add(entry.getValue());
//        }
        if(type.equals("price"))
        {
//            System.out.println("Inside price strategy");
            strategy = new PriceStrategy();
            restaurants = strategy.getRestaurants(restaurants);
        }
        else if (type.equals("rating"))
        {
//            System.out.println("Inside rating strategy");
            strategy = new RatingStrategy();
            restaurants = strategy.getRestaurants(restaurants);
        }
        List<Restaurant> serviceAbleRestaurant = restaurants.stream().filter(x -> x.getFood().getQuantity() > 0).collect(Collectors.toList());
//        System.out.println(serviceAbleRestaurant);
        return serviceAbleRestaurant;
    }

    public Order placeOrder(String name,int quantity)
    {
        if(restaurantMap.containsKey(name))
        {
            Restaurant restaurant = restaurantMap.get(name);
            if(restaurant.placeOrder(quantity))
            {
                Order order = new Order(restaurant.getFood().getFoodName(),loggedInUser,restaurant);
                System.out.println("Order Placed Successfully.");
                return order;
            }
            else
            {
                System.out.println("Cannot place Order 1");
            }
        }
        else
            System.out.println("Cannot place Order 2");
        return null;
    }

    public void createReview(String name,int rating,String comment)
    {
        Restaurant restaurant = restaurantMap.get(name);
        restaurant.createReview(rating,comment);
    }
}

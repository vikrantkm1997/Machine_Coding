package Strategy;

import Entity.Restaurant;

import java.util.List;

public interface Strategy {

    public List<Restaurant> getRestaurants(List<Restaurant> restaurantList);
}

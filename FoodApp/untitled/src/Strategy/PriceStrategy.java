package Strategy;

import Entity.Restaurant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PriceStrategy implements Strategy{
    public PriceStrategy() {
    }

    @Override
    public List<Restaurant> getRestaurants(List<Restaurant> restaurantList)
    {
        Collections.sort(restaurantList, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                if(o1.getFood().getPrice() < o2.getFood().getPrice())
                    return 1;
                else if(o1.getFood().getPrice() > o2.getFood().getPrice())
                    return -1;
                else
                    return 0;
            }
        });
        return restaurantList;
    }
}

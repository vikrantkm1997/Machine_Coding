package Strategy;

import Entity.Restaurant;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RatingStrategy implements Strategy{

    @Override
    public List<Restaurant> getRestaurants(List<Restaurant> restaurantList) {
        Collections.sort(restaurantList, new Comparator<Restaurant>() {
            @Override
            public int compare(Restaurant o1, Restaurant o2) {
                if(o2.getRating() > o1.getRating())
                    return 1;
                else if(o2.getRating() < o1.getRating())
                    return -1;
                else
                    return 0;
            }
        });
        return restaurantList;
    }
}

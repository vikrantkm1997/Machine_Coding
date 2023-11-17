import Entity.Order;
import Entity.Restaurant;
import Entity.User;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FoodKartApp foodKartApp = new FoodKartApp();
//        register_user(“Pralove”, “M”, “phoneNumber-1”, “HSR”)
//        register_user(“Nitesh”, “M”, “phoneNumber-2”, “BTM”)
//        register_user(“Vatsal”, “M”,  “phoneNumber-3”, “BTM”)
//        login_user(“phoneNumber-1”)
        foodKartApp.registerUser("Parlove","M","phoneNumber-1","HSR");
        foodKartApp.registerUser("Nitesh","M","phoneNumber-2","BTM");
        foodKartApp.registerUser("Vatsal","M","phoneNumber-3","BTM");

        foodKartApp.userLogin("phoneNumber-1");
//      register_restaurant(“Food Court-1”, “BTM/HSR”, “NI Thali”, 100, 5)
        foodKartApp.registerRestaurant("Food Court-1","BTM/HSR","NI Thali",100,5);
//      register_restaurant(“Food Court-2”, “BTM”, “Burger”, 120, 3)

        foodKartApp.registerRestaurant("Food Court-2","BTM","Burger",120,3);
//      login_user(“phoneNumber-2”)
        foodKartApp.userLogin("phoneNumber-2");
//        register_restaurant(“Food Court-3”, “HSR”, “SI Thali”, 150, 1)
        foodKartApp.registerRestaurant("Food Court-3","HSR","SI Thali",150,1);
//        login_user(“phoneNumber-3”)
        foodKartApp.userLogin("phoneNumber-3");
//        show_restaurant(“price”)
        List<Restaurant> restaurants = foodKartApp.showRestaurant("price");
        for(Restaurant restaurant:restaurants)
            System.out.println(restaurant.getName()+" "+ restaurant.getFood().getFoodName()+" "+restaurant.getRating());
//        place_order(“Food Court-1”, 2)
        Order order = foodKartApp.placeOrder("Food Court-1",2);
//        place_order(““Food Court-2”, 7)
        foodKartApp.placeOrder("Food Court-2",7);

//        create_review(“Food Court-2”, 3, “Good Food”)
//        create_review(“Food Court-1”, 5, “Nice Food”)

        foodKartApp.createReview("Food Court-2",3,"Good Food");
        foodKartApp.createReview("Food Court-1",5,"Nice Food");

//        show_restaurant(“rating”)
        restaurants = foodKartApp.showRestaurant("rating");
        for(Restaurant restaurant:restaurants)
            System.out.println(restaurant.getName()+" "+ restaurant.getFood().getFoodName()+" "+restaurant.getRating());

        foodKartApp.userLogin("phoneNumber-1");
//        update_quantity(“Food Court-2”, 5)

        foodKartApp.updateQuantity("Food Court-2", 5);


    }
}
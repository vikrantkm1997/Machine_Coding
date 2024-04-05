import enums.Gender;
import enums.VehicleType;

public class Main {
    public static void main(String[] args) {
        RideSharingApp rideSharingApp = new RideSharingApp();
        rideSharingApp.addUser("Rohan", Gender.MALE,36);
        rideSharingApp.addVehicle("Rohan", VehicleType.SWIFT, "KA-01-12345");
        rideSharingApp.addUser("Shashank", Gender.MALE,29);
        rideSharingApp.addVehicle("Shashank", VehicleType.BALENO, "TS-05-62395");
        rideSharingApp.addVehicle("Rohan", VehicleType.SWIFT, "KA-01-12345");
        rideSharingApp.addUser("Nandini", Gender.FEMALE,29);
        rideSharingApp.addUser("Shipra", Gender.FEMALE, 27);
        rideSharingApp.addVehicle("Shipra", VehicleType.POLO, "KA-05-41491");
        rideSharingApp.addVehicle("Shipra", VehicleType.ACTIVA, "KA-12-12332");
        rideSharingApp.addUser("Gaurav", Gender.MALE, 29);
        rideSharingApp.addUser("Rahul", Gender.MALE, 35);
        rideSharingApp.addVehicle("Rahul", VehicleType.XUV, "KA-05-1234");

        rideSharingApp.offerRide("Rohan", "Hyderabad", "Bangalore",1, VehicleType.SWIFT, "KA-01-12345");
        rideSharingApp.offerRide("Shipra", "Bangalore", "Mysore",1, VehicleType.ACTIVA, "KA-12-12332");
        rideSharingApp.offerRide("Shipra", "Bangalore", "Mysore",2, VehicleType.POLO, "KA-05-41491");
        rideSharingApp.offerRide("Shashank", "Hyderabad", "Bangalore",2, VehicleType.BALENO, "TS-05-62395");
        rideSharingApp.offerRide("Rahul", "Hyderabad", "Bangalore", 5, VehicleType.XUV, "KA-05-1234");
        rideSharingApp.offerRide("Rohan", "Hyderabad", "Bangalore",1, VehicleType.SWIFT, "KA-01-12345");

        rideSharingApp.selectRide("Nandini","Bangalore","Mysore", 1, "Most Vacant");
        rideSharingApp.selectRide("Gaurav","Bangalore","Mysore", 1, "Vehicle=Activa");
        rideSharingApp.selectRide("Shashank","Mumbai","Bangalore", 1, "Most Vacant");
        rideSharingApp.selectRide("Rohan","Hyderabad","Bangalore", 1, "Vehicle=Baleno");
        rideSharingApp.selectRide("Shashank","Hyderabad","Bangalore", 1, "Vehicle=Polo");

        rideSharingApp.endRide(1);
        rideSharingApp.endRide(2);
        rideSharingApp.endRide(3);
        rideSharingApp.endRide(4);

        rideSharingApp.printRideStats();


    }
}
//Onboard 5 users
//    add_user(“Rohan, M, 36”); add_vehicle(“Rohan, Swift, KA-01-12345)
//    add_user(“Shashank, M, 29”); add_vehicle(“Shashank, Baleno, TS-05-62395)
//    add_user(“Nandini, F, 29)
//    add_user(“Shipra, F, 27”) ; add_vehicle(“Shipra”, Polo, KA-05-41491); add_vehicle(“Shipra, Activa KA-12-12332”)
//    add_user(“Gaurav, M, 29)
//    add_user(“Rahul, M, 35); add_vehicle(“Rahul”, “XUV”, KA-05-1234);
//    Offer 4 rides by 3 users
//    offer_ride(“Rohan, Origin=Hyderabad, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination= Bangalore”)
//    offer_ride(“Shipra, Origin=Bangalore, Available Seats=1, Vehicle=Activa KA-12-12332, Destination=Mysore”)
//    offer_ride(“Shipra, Origin=Bangalore, Available Seats=2, Vehicle=Polo, KA-05-41491, Destination=Mysore”)
//    offer_ride(“Shashank, Origin=Hyderabad, Available Seats=2, Vehicle=Baleno, TS-05-62395, Destination=Bangalore”)
//    offer_ride(“Rahul, Origin=Hyderabad, Available Seats=5, Vehicle=XUV, KA-05-1234, Destination=Bangalore”)
//    offer_ride(“Rohan, Origin=Bangalore, Available Seats=1, Vehicle=Swift, KA-01-12345, Destination=Pune”)
//    This call should fail, since a ride has already been offered by this user for this vehicle.
//    Find rides for 4 users
//    select_ride(“Nandini, Origin=Bangalore, Destination=Mysore, Seats=1, Most Vacant”)
//    2(c) is the desired output.
//    select_ride(“Gaurav, Origin=Bangalore, Destination=Mysore, Seats=1, Preferred Vehicle=Activa”)
//    2(b) is the desired output
//    select_ride(“Shashank, Origin=Mumbai, Destination=Bangalore, Seats=1, Most Vacant”)
//    No rides found
//    select_ride(“Rohan, Origin=Hyderabad, Destination=Bangalore, Seats=1, Preferred Vehicle=Baleno”)
//    2(d) is the desired output
//    select_ride(“Shashank, Origin=Hyderabad, Destination=Bangalore, Seats=1,Preferred Vehicle=Polo”)
//    No rides found
//    End Rides
//    end_ride(2-a)
//    end_ride(2-b)
//    end_ride(2-c)
//    end_ride(2-d)
//    Find total rides by user: Rides Taken: Rides that have were taken and have been marked as “ended”
//    Rides Offered: Rides that were offered and have been marked as “ended”.
//    Note: Even if the offered ride was not taken by any user, it counts as an offered ride.
//    print_ride_stats()
//    Nandini: 1 Taken, 0 Offered
//    Rohan: 1 Taken, 1 Offered
//    Shashank: 0 Taken, 1 Offered
//    Gaurav: 1 Taken, 0 Offered
//    Rahul: 0 Taken, 0 Offered
//    Shipra: 0 Taken, 2 Offered
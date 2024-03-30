import Driver.OnlineBidding;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        OnlineBidding onlineBidding = new OnlineBidding();
        onlineBidding.addUser(1, "Akshay", 10000);
        onlineBidding.addUser(2,"Chris",5000);
        onlineBidding.addUser(3,"John",7000);
        onlineBidding.addEvent(1, "BBD","IPhone");
        onlineBidding.registerMember(1,1);
        onlineBidding.registerMember(2,1);
        onlineBidding.subMitBid(1,1, Set.of(100,200,400,500,600));
        onlineBidding.subMitBid(2,1,Set.of(100,200,400,500));
        onlineBidding.subMitBid(3,1,Set.of(120,200,300,250));
        onlineBidding.declareWinner(1);
    }
}
//ADD_MEMBER <number_of_super_coins>
//a. Example : ADD_MEMBER 1 akshay 10000
//    b. Output : Akshay added successfully
//    c. Example : ADD_MEMBER 2 chris 5000
//    d. Output : Chris added successfully
//    ADD_EVENT <event_name> <prize_name>
//a. Example : ADD_EVENT 1 BBD IPHONE-14 2023-06-06
//    b. Output : BBD with prize IPHONE-14 added successfully
//    REGISTER_MEMBER <member_id> <event_id>
//a. Example : REGISTER_MEMBER 1 1
//    b. Output : Akshay registered to the BBD event successfully
//    SUBMIT_BID <member_id> <event_id> <bid_1> <bid_2> <bid_3> <bid_4> <bid_5> a. Example : SUBMIT_BID 1 1 100 200 400 500 600
//    b. Output : BIDS submitted successfully
//    c. Example SUBMIT_BID 2 1 100 200 400 500
//    d. Output : BIDS submitted successfully
//    e. Example : SUBMIT_BID 10 1 100 200 300 400 500
//    f. Output : Member did not registered for this event
//    DECLARE_WINNER EVENT_ID
//    a. Example : DECLARE_WINNER 1
//    b. Output : Akshay wins the IPHONE-14 with lowest bid 100
//    BONUS





















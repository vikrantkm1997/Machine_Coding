package Driver;

import Entity.Bid;
import Entity.Event;
import Entity.User;
import Exceptions.BidValidationFailed;
import Exceptions.EventNotFound;
import Exceptions.UserDidNotRegister;
import Exceptions.UserNotFound;
import IdGenerator.IdGenerator;
import Manager.EventManager;
import Manager.UserManager;

import java.util.*;

public class OnlineBidding {
    private EventManager eventManager;
    private UserManager userManager;

    private IdGenerator idGenerator;

    private Map<Integer, List<Bid>> eventToBidMap;

    private Map<Integer, List<Integer>> eventToUserIdMap;

    public OnlineBidding() {
        eventManager = EventManager.getInstance();
        userManager = UserManager.getInstance();
        this.eventToBidMap = new HashMap<>();
        this.eventToUserIdMap = new HashMap<>();
    }

    public void addEvent(int eventId, String eventName, String eventPrice) {
//        int eventId = IdGenerator.getEventId();
        Event event = eventManager.addEvent(eventId, eventName, eventPrice);
        if (event != null)
            System.out.println(event.getName() + " with Prize " + event.getPrize() + " added successFully");
    }

    public void addUser(int memberId, String userName, int superCoins) {
//        int userId = IdGenerator.getUserId();
        User user = userManager.addMember(memberId, userName, superCoins);
        System.out.println(user.getUserName() + " added successFully");
    }

    public void registerMember(int memberId, int eventId) {
        List<Integer> userIds = eventToUserIdMap.getOrDefault(eventId, new ArrayList<>());
        userIds.add(memberId);
        eventToUserIdMap.put(eventId, userIds);
        User user = userManager.getMember(memberId);
        Event event = eventManager.getEvent(eventId);
        if (user != null && event != null)
            System.out.println(user.getUserName() + " registered to event " + event.getName() + "successFully");
        else
            throw new RuntimeException("User or Event not found");
    }

    public void subMitBid(int memberId, int eventId, Set<Integer> bidAmounts) {
        Event event = eventManager.getEvent(eventId);
        try {
            if (event == null)
                throw new EventNotFound("Event not Found");
            User user = userManager.getMember(memberId);
            if (user == null) {
                throw new UserNotFound("User not found");
            }

            if (!eventToUserIdMap.get(eventId).contains(memberId)) {
                throw new UserDidNotRegister();
            }
            if (validateBids(user, bidAmounts)) {
                int maxAmt = bidAmounts.stream()
                    .mapToInt(Integer::intValue)
                    .max()
                    .orElse(-1);
                int minAmt = bidAmounts.stream()
                    .mapToInt(Integer::intValue)
                    .min()
                    .orElse(-1);
                Bid bid = new Bid(idGenerator.getBidId(), memberId, minAmt, maxAmt);
                List<Bid> bids = eventToBidMap.getOrDefault(eventId, new ArrayList<Bid>());
                bids.add(bid);
                eventToBidMap.put(eventId, bids);
            } else {
                throw new BidValidationFailed();
            }
        } catch (Exception e) {
            System.out.println("Exception happens " + e.getMessage());
        }

    }

    public Boolean validateBids(User user, Set<Integer> bidAmounts) {
        int userSuperCoins = user.getSuperCoins();
        int maxAmt = bidAmounts.stream()
            .mapToInt(Integer::intValue)
            .max()
            .orElse(-1);

        return (bidAmounts.size() <=5 && maxAmt <= user.getSuperCoins());
    }

    public void declareWinner(int eventId) {
        List<Bid> bids = eventToBidMap.get(eventId);
        Optional <Bid> bid = bids.stream().min(Comparator.comparingInt(Bid::getMinBin).thenComparing(Bid::getId));
        User winner = userManager.getMember(bid.get().getUserId());
        Event event = eventManager.getEvent(eventId);
        System.out.println(winner.getUserName()+" wins "+event.getPrize()+ "with lowest bid "+ bid.get().getMinBin());
    }

}
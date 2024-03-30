package Manager;

import Entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<Integer, User> idToUserMap;
    private UserManager () {
        this.idToUserMap = new HashMap<>();
    }

    private static UserManager userManagerInstance;

    public static UserManager getInstance() {
        if(userManagerInstance == null)
        {
            userManagerInstance = new UserManager();
        }
        return userManagerInstance;
    }

    public User addMember(int userId, String userName, int superCoins) {
        User user = new User(userId, userName, superCoins);
        this.idToUserMap.put(userId, user);
        return user;
    }

    public User getMember(int memberId) {
        return this.idToUserMap.get(memberId);
    }

}

package models.manager;

import models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserManager {
    private Map<Integer, User> idToUserMap;

    private UserManager() {
        this.idToUserMap = new HashMap<>();
    }

    private static UserManager userManagerInstance;
    public static UserManager getInstance() {
        if(userManagerInstance == null){
            userManagerInstance = new UserManager();
        }
        return userManagerInstance;
    }

    public void addUser(User user) {
        idToUserMap.put(user.getId(), user);
        System.out.println("User added "+ user.getUserName());
    }

    public Optional<User> getUser(String userName) {
        return idToUserMap.values().stream().filter(it -> it.getUserName().equals(userName)).findFirst();
    }

    public Optional<User> getUserByUserId(int id) {
        return idToUserMap.values().stream().filter(it-> it.getId() == id).findFirst();
    }
}

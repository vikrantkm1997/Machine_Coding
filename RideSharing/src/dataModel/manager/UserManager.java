package dataModel.manager;

import dataModel.User;
import enums.Gender;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String , User> nameToUserMap;

    private static UserManager userManagerInstance;
    private UserManager() {
        this.nameToUserMap = new HashMap<>();
    }

    public Map<String, User> getNameToUserMap() {
        return nameToUserMap;
    }

    public static UserManager getInstance() {
        if(userManagerInstance == null) {
            userManagerInstance = new UserManager();
        }
        return userManagerInstance;
    }

    public void addUser(String name, Gender gender, int age) {
        User user = new User(name, gender, age);
        this.nameToUserMap.put(name, user);
    }
}

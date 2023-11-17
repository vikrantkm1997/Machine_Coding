package Entity;

import Enum.Gender;
public class User {
    String name;
    Gender gender;
    String MOBILE;
    String location;

    public User(String name, String gender, String MOBILE, String location) {
        this.name = name;
        this.MOBILE = MOBILE;
        this.location = location;
        if(gender.equals("M"))
            this.gender = Gender.MALE;
        else
            this.gender = Gender.FEMALE;
    }

    public String getLocation() {
        return location;
    }
}

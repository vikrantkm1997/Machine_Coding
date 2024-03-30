package Exceptions;

import Manager.UserManager;

public class UserNotFound extends RuntimeException{
        public UserNotFound(String message) {
        super(message);
    }
}

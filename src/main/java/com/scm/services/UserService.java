package com.scm.services;

import com.scm.entities.User;
import java.util.*;

public interface UserService {
    
    User saveUser(User user);
    Optional<User>getUserById(String id);
    Optional<User>updateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String userId);
    boolean isUserExistByEmail(String enail);
    List<User> getAllUsers();

    //Add more methods here related to user service[logic]
}

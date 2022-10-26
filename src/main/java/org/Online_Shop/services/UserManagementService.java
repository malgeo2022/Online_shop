package org.Online_Shop.services;

import org.Online_Shop.enteties.User;

import java.util.List;

public interface UserManagementService {
    String registerUser(User user);

    List<User> getUsers();

    User getUserByEmail(String userEmail);

}

package org.Online_Shop.services;

import org.Online_Shop.enteties.User;

public interface UserManagementService {
    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);

}

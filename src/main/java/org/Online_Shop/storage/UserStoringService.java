package org.Online_Shop.storage;

import org.Online_Shop.enteties.User;

import java.util.List;

public interface UserStoringService {
    void saveUser(User user);

    List<User> loadUsers();
}

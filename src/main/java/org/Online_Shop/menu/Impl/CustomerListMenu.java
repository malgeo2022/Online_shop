package org.Online_Shop.menu.Impl;

import org.Online_Shop.configs.ApplicationContext;
import org.Online_Shop.enteties.User;
import org.Online_Shop.menu.Menu;
import org.Online_Shop.services.Impl.DefaultUserManagementService;
import org.Online_Shop.services.UserManagementService;

import java.util.List;

public class CustomerListMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        List<User> users = userManagementService.getUsers();

        if (users == null || users.size() == 0) {
            System.out.println("Unfortunately, there are no customers.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }


}

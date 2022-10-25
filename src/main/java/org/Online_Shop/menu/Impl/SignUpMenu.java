package org.Online_Shop.menu.Impl;

import org.Online_Shop.configs.ApplicationContext;
import org.Online_Shop.enteties.Impl.DefaultUser;
import org.Online_Shop.enteties.User;
import org.Online_Shop.menu.Menu;
import org.Online_Shop.services.Impl.DefaultUserManagementService;
import org.Online_Shop.services.UserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {
    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter your first name: ");
        String firstName = sc.next();
        System.out.print("Please, enter your last name: ");
        String lastName = sc.next();
        System.out.print("Please, enter your password: ");
        String password = sc.next();
        System.out.print("Please, enter your email: ");

        sc = new Scanner(System.in);
        String email = sc.nextLine();

        User user = new DefaultUser(firstName, lastName, password, email);

        String errorMessage = userManagementService.registerUser(user);
        if (errorMessage == null || errorMessage.isEmpty()) {
            context.setLoggedInUser(user);
            System.out.println("New user is created");
        } else {
            System.out.println(errorMessage);
        }

        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** SIGN UP *****");
    }

}

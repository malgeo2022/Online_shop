package org.Online_Shop.menu.Impl;

import org.Online_Shop.enteties.User;
import org.Online_Shop.menu.Menu;
import org.Online_Shop.services.Impl.DefaultUserManagementService;
import org.Online_Shop.services.UserManagementService;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;


public class ResetPasswordMenu implements Menu {
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        System.out.println("Your password has been sent to your email. Please, check mailbox. You will receive the email within the next 5 minutes");
        CompletableFuture.runAsync(() -> {
            User user = userManagementService.getUserByEmail(userInput);
            userManagementService.resetPasswordForUser(user);
        });
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** RESET PASSWORD *****");
        System.out.print("Enter your email: ");
    }
}

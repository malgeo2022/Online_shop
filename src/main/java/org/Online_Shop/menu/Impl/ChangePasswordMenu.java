package org.Online_Shop.menu.Impl;

import org.Online_Shop.configs.ApplicationContext;
import org.Online_Shop.menu.Menu;

import java.util.Scanner;

public class ChangePasswordMenu implements Menu {

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        context.getLoggedInUser().setPassword(userInput);
        System.out.println("Your Password has been successfully changed");
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*****CHANGE PASSWORD");
        System.out.println("Enter new Password: ");
    }
}

package org.Online_Shop.menu.Impl;

import org.Online_Shop.configs.ApplicationContext;
import org.Online_Shop.menu.Menu;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        context.getLoggedInUser().setEmail(userInput);
        System.out.println("Your email has been successfully changed ");
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** CHANGE EMAIL *****");
        System.out.println("Enter new Email: ");
    }

}

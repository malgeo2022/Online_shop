package org.Online_Shop.menu.Impl;

import org.Online_Shop.configs.ApplicationContext;
import org.Online_Shop.enteties.User;
import org.Online_Shop.menu.Menu;
import org.Online_Shop.services.Impl.DefaultUserManagementService;
import org.Online_Shop.services.UserManagementService;

import java.util.ResourceBundle;
import java.util.Scanner;

public class SignInMenu implements Menu {
    private ApplicationContext context;
    private UserManagementService userManagementService;
    private ResourceBundle rb;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
        rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);

        System.out.print(rb.getString("please.enter.email"));
        String userEmail = sc.next();

        System.out.print(rb.getString("please.enter.pass"));
        String userPassword = sc.next();

        User user = userManagementService.getUserByEmail(userEmail);
        if (user != null && user.getPassword().equals(userPassword)) {
            System.out.printf(rb.getString("glad.to.see.you.back"), user.getFirstName(),
                    user.getLastName() + System.lineSeparator());
            context.setLoggedInUser(user);
        } else {
            System.out.println(rb.getString("login.and.password.not.exist"));
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println(rb.getString("sign.in.header"));
    }

}

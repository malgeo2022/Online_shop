package org.Online_Shop.menu.Impl;

import org.Online_Shop.configs.ApplicationContext;
import org.Online_Shop.enteties.User;
import org.Online_Shop.menu.Menu;
import org.Online_Shop.services.Impl.DefaultUserManagementService;
import org.Online_Shop.services.UserManagementService;

import java.util.ResourceBundle;


public class SignOutMenu implements Menu {
    private ApplicationContext context;
    private ResourceBundle rb;

    {
        context = ApplicationContext.getInstance();
        rb = ResourceBundle.getBundle(RESOURCE_BUNDLE_BASE_NAME);
    }

    @Override
    public void start() {
        printMenuHeader();
        context.setLoggedInUser(null);
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println(rb.getString("sign.out.header"));
        System.out.println(rb.getString("bye.msg"));
    }
}

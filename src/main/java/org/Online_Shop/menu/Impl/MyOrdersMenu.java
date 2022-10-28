package org.Online_Shop.menu.Impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.Online_Shop.configs.ApplicationContext;
import org.Online_Shop.enteties.Purchase;
import org.Online_Shop.menu.Menu;
import org.Online_Shop.services.Impl.DefaultOrderManagementService;
import org.Online_Shop.services.Impl.MySqlPurchaseManagementService;
import org.Online_Shop.services.Impl.PurchaseManagementService;

import java.util.List;

public class MyOrdersMenu implements Menu {
    private ApplicationContext context;
    private PurchaseManagementService purchaseManagementService;

    {
        context = ApplicationContext.getInstance();
        purchaseManagementService = new MySqlPurchaseManagementService();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null) {
            System.out.println(
                    "Please, log in or create new account to see list of your orders");
            new MainMenu().start();
            return;
        } else {
            printUserOrdersToConsole();
        }
        new MainMenu().start();
    }

    private void printUserOrdersToConsole() {
        List<Purchase> loggedInUserOrders = purchaseManagementService
                .getPurchasesByUserId(context.getLoggedInUser().getId());
        if (loggedInUserOrders == null || loggedInUserOrders.size() == 0) {
            System.out.println(
                    "Unfortunately, you don't have any orders yet. "
                            + "Navigate back to main menu to place a new order");
        } else {
            for (Purchase order : loggedInUserOrders) {
                System.out.println(order);
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** MY ORDERS *****");
    }

}

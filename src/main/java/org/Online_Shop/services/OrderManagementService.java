package org.Online_Shop.services;

import org.Online_Shop.enteties.Order;

public interface OrderManagementService {
    void addOrder(Order order);

    Order[] getOrdersByUserId(int userId);

    Order[] getOrders();
}

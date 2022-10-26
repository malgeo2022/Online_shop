package org.Online_Shop.services.Impl;

import org.Online_Shop.enteties.Order;
import org.Online_Shop.services.OrderManagementService;
import org.Online_Shop.storage.OrderStoringService;
import org.Online_Shop.storage.impl.DefaultOrderStoringService;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultOrderManagementService implements OrderManagementService {

    private static DefaultOrderManagementService instance;
    private List<Order> orders;
    private OrderStoringService orderStoringService;

    {
        orderStoringService = DefaultOrderStoringService.getInstance();
        orders = orderStoringService.loadOrders();
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) {
            return;
        }
        orders.add(order);
        orderStoringService.saveOrders(orders);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderStoringService.loadOrders().stream()
                .filter(Objects::nonNull)
                .filter(order -> order.getCustomerId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrders() {
        if (orders == null || orders.size() == 0) {
            orders = orderStoringService.loadOrders();
        }
        return this.orders;
    }

    void clearServiceState() {
        orders.clear();
    }
}

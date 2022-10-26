package org.Online_Shop.storage;

import org.Online_Shop.enteties.Order;

import java.util.List;

public interface OrderStoringService {
    void saveOrders(List<Order> order);

    List<Order> loadOrders();
}

package org.Online_Shop.storage;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.List;

public interface OrderStoringService {
    void saveOrders(List<MysqlxCrud.Order> order);

    List<MysqlxCrud.Order> loadOrders();
}

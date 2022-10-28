package org.Online_Shop.storage.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.Online_Shop.storage.OrderStoringService;

import java.io.*;
import java.util.List;

public class DefaultOrderStoringService implements OrderStoringService {
    private static final String ORDERS_DATA_FILE_NAME = "orders.data";
    private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
    private static final String RESOURCES_FOLDER = "resources";

    private static DefaultOrderStoringService instance;

    private DefaultOrderStoringService() {
    }

    @Override
    public void saveOrders(List<MysqlxCrud.Order> orders) {
        try (var oos = new ObjectOutputStream(new FileOutputStream(
                RESOURCES_FOLDER + File.separator + CURRENT_TASK_RESOURCE_FOLDER
                        + File.separator + ORDERS_DATA_FILE_NAME
        ))) {
            oos.writeObject(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MysqlxCrud.Order> loadOrders() {
        try (var ois = new ObjectInputStream(new FileInputStream(
                RESOURCES_FOLDER + File.separator + CURRENT_TASK_RESOURCE_FOLDER
                        + File.separator + ORDERS_DATA_FILE_NAME
        ))) {
            return (List<MysqlxCrud.Order>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static OrderStoringService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderStoringService();
        }
        return instance;
    }

}

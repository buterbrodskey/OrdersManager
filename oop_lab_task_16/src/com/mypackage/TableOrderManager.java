package com.mypackage;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TableOrderManager implements OrdersManager {
    //private static TableOrderManager tableOrderManager = new TableOrderManager();

    private TreeMap<Integer, Order> orders = new TreeMap<>();


    public TableOrderManager() {
    }

    void addOrder(Order order, int numTable) throws OrderAlreadyException {
        if (orders.containsKey(numTable)) {
            throw new OrderAlreadyException("This table is exists!");
        }
        orders.put(numTable, order);
    }


    void showAllOrders() {
        System.out.println("Table of Orders:\n");
        orders.forEach((N, O) -> {
            System.out.print("Number of order: " + N +"\n\t");
            O.showOrder();
        });
    }

    @Override
    public int itemsQuantity(String itemName) {
        return orders.entrySet()
                .stream()
                .mapToInt(s -> s.getValue().itemsQuantity(itemName))
                .sum();
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return orders.entrySet()
                .stream()
                .mapToInt(s -> s.getValue().itemsQuantity(item))
                .sum();
    }

    @Override
    public Order[] getOrders() {
        return orders.values().toArray(new Order[0]);
    }

    @Override
    public int ordersCostSummary() {
        return 0;
    }

    @Override
    public int ordersQuantity() {
        return 0;
    }


    //static TableOrderManager getInstance() {
    //    return tableOrderManager;
   // }
}

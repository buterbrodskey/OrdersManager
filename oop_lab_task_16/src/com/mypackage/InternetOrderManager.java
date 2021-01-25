package com.mypackage;

public class InternetOrderManager implements OrdersManager {
    QueueNode head;
    QueueNode tail;
    int size;
    boolean add(Order order) {
        return false;
    }

    @Override
    public int itemsQuantity(String itemName) {
        return 0;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return 0;
    }

    @Override
    public Order[] getOrders() {
        return new Order[0];
    }

    @Override
    public int ordersCostSummary() {
        return 0;
    }

    @Override
    public int ordersQuantity() {
        return 0;
    }

    Order remove() {
        return null;
    }

    Order order() {
        return null;
    }
}

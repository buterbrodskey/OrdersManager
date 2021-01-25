package com.mypackage;

public interface Order {
    boolean addItem(MenuItem menuItem);

    boolean removeOneItem(String name);

    int removeItem(String name);

    int getSize();

    MenuItem[] toItemArray();

    void setCustomer(Customer customer);

    Customer getCustomer();

    int getPrice();

    int getItemCount(String name);

    String[] itemsNames();

    MenuItem[] getItems();

    int costTotal();

    MenuItem[] toSortedStringArray();

    int itemsQuantity(String name);

    int itemsQuantity(MenuItem item);

    void showOrder();
}

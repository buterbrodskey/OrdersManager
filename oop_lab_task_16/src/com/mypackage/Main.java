package com.mypackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("where is the order made? restaurant or internet? (r/i)");

        if (scanner.next().equals("r")) {
        //    RestaurantOrder order = new RestaurantOrder();
        }
        else if (scanner.next().equals("i")) {

        }
        else {

        }
//        TableOrderManager orderManager = TableOrderManager.getInstance();
//
//        {
//            RestaurantOrder restaurantOrder = new RestaurantOrder(new Dish(9,"Snacker", "not chili"));
//            restaurantOrder.addItem(new Dish(12,"Snacker", "chili is good, not tomato"));
//            restaurantOrder.addItem(new Dish(12,"Snacker", "chili is good, not tomato"));
//            restaurantOrder.addItem(new Drink(4,"Cola Vanilla", "ice"));
//            restaurantOrder.addItem(new Drink(15,"Cola Vanilla", "normal"));
//
//            try {
//                orderManager.addOrder(restaurantOrder,2);
//            } catch (OrderAlreadyException e) {
//                e.printStackTrace();
//            }
//            System.out.println(restaurantOrder.getPrice());
//        }
//
//        {
//            RestaurantOrder restaurantOrder2 = new RestaurantOrder(new Dish(16,"Snacker", "not chili"));
//            restaurantOrder2.addItem(new Dish(16,"Snacker", "not chili"));
//            restaurantOrder2.addItem(new Drink(15,"Cola Vanilla", "ice"));
//            restaurantOrder2.addItem(new Drink(15,"Cola Vanilla", "ice"));
//
//            try {
//                orderManager.addOrder(restaurantOrder2, 5);
//            } catch (OrderAlreadyException e) {
//                e.printStackTrace();
//            }
//        }
//
////        orderManager.showAllOrders();
//        InternetOrder internetOrder = new InternetOrder(new Item[] {new Drink(15,"Cola", "ice"), new Dish(12,"PURE", "S KOTLETKAMI")});
//        internetOrder.showOrder();
//
//        internetOrder.addItem(new Drink(12,"coffee","hot"));
//        internetOrder.addItem(new Drink(12,"coffee","hot not sugar"));
//        internetOrder.addItem(new Drink(12,"coffee","ice"));
//        internetOrder.addItem(new Drink(12,"coffee","hot"));
//        internetOrder.showOrder();
//
//        System.out.println(internetOrder.removeOneItem("PURE"));
//        internetOrder.showOrder();
//
//
//
//
//        internetOrder.addItem(new Drink(12,"coffee","hot"));
//        internetOrder.addItem(new Drink(14,"coffee","hot with choco"));
//        System.out.println("Размер заказа: " + internetOrder.getSize());
//        internetOrder.showOrder();
//        internetOrder.removeItem("coffee");
//        internetOrder.showOrder();
//        System.out.println("Размер заказа: " + internetOrder.getSize());
//
//
//
//        internetOrder.addItem(new Dish(4,"ChocoPie","broken up"));
//        internetOrder.addItem(new Dish(4,"ChocoPie","broken up"));
//        internetOrder.addItem(new Dish(4,"ChocoPie","broken up"));
//
//        Item[] items = internetOrder.toItemArray();
//        System.out.println("Вывожу массив заказанных блюд и напитков:");
//        for (Item item : items) {
//            System.out.println(item);
//        }
//        System.out.println("Вывeл");
//
//        System.out.println(internetOrder.getPrice());
//
//        System.out.println(internetOrder.getItemCount("ChocoPie"));
//        System.out.println(internetOrder.getItemCount("Coffee"));
//        System.out.println(internetOrder.getItemCount("Cola"));
//
//
//        String[] pos = internetOrder.toStringArray();
//        Arrays.stream(pos).forEach(System.out::println);
//
//
//        Item[] set = internetOrder.toSortedStringArray();
//        System.out.println("Отсортированны по убыванию цены: ");
//        Arrays.stream(set).forEach(System.out::println);
    }


}

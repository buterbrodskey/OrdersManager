package com.mypackage;

import java.util.*;

public class RestaurantOrder implements Order{
    ArrayList<NodeOrder> order = new ArrayList<>();
    Customer customer;
    private int numTable = -1;

    private class NodeOrder {
        MenuItem menuItem;
        int count;

        public NodeOrder(MenuItem menuItem, int count) {
            this.menuItem = menuItem;
            this.count = count;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeOrder nodeOrder = (NodeOrder) o;
            return this.menuItem.getName().equals(((NodeOrder) o).menuItem.getName()) && this.menuItem.getDescription().equals(((NodeOrder) o).menuItem.getDescription());
        }

        @Override
        public int hashCode() {
            return Objects.hash(menuItem, count);
        }

        @Override
        public String toString() {
            return "NodeOrder{" +
                    "menuItem=" + menuItem +
                    ", count=" + count +
                    '}';
        }
    }
    RestaurantOrder(int numTable) {

    }

    RestaurantOrder(MenuItem menuItem) {
        addItem(menuItem);
    }

    RestaurantOrder(MenuItem menuItem, int numTable) {
        addItem(menuItem);
        this.numTable = numTable;
    }

    public int getNumTable() {
        return numTable;
    }

    public boolean addItem(MenuItem menuItem) {
        for (NodeOrder nodeOrder : order) {
            if (menuItem.equals(nodeOrder.menuItem)) {
                nodeOrder.count++;
                return true;
            }
        }
        order.add(new NodeOrder(menuItem,1));
        return true;
     }

    @Override
    public boolean removeOneItem(String name) {
        for (NodeOrder nodeOrder : order) {
            if (nodeOrder.menuItem.getName().equals(name)) {
                order.remove(order.indexOf(nodeOrder));
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeItem(String name) {
        int counter = 0;
        for (NodeOrder nodeOrder : order) {
            if (nodeOrder.menuItem.getName().equals(name)) {
                counter+=nodeOrder.count;
                order.remove(order.indexOf(nodeOrder));
            }
        }
        return counter;
    }

    @Override
    public int getSize() {
        return order.size();
    }


    @Override
    public MenuItem[] toItemArray() {
        MenuItem[] menuItems = new MenuItem[getSize()];
        for (int i = 0; i < order.size(); i++) {
            menuItems[i] = order.get(i).menuItem;
        }
        return menuItems;
    }

    @Override
    public int getPrice() {
        int price = 0;
        for (NodeOrder nodeOrder : order) {
            price+=nodeOrder.menuItem.getPrice()*nodeOrder.count;
        }
        return price;
    }

    @Override
    public int getItemCount(String name) {
        return order.size();
    }

    @Override
    public String[] itemsNames() {
            String[] items = new String[getSize()];
            for (int i = 0; i < order.size(); i++) {
                items[i] = order.get(i).menuItem.getName();
            }
            return items;
    }

    @Override
    public MenuItem[] getItems() {
        return (MenuItem[]) order.stream().map(s -> s.menuItem).toArray();
    }

    @Override
    public int costTotal() {
        return order.stream()
                .mapToInt(s -> s.menuItem.getPrice()*s.count)
                .sum();
    }

    @Override
    public int itemsQuantity(String name) {
        return order.stream()
                .filter(s -> s.menuItem.getName().equals(name))
                .mapToInt(s-> s.count)
                .sum();
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return order.stream()
                .filter(s-> s.menuItem.equals(item))
                .mapToInt(s->s.count)
                .sum();
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public MenuItem[] toSortedStringArray() {
        Comparator<NodeOrder> comparator = new Comparator<>() {
            @Override
            public int compare(NodeOrder o1, NodeOrder o2) {
                return o2.menuItem.getPrice() - o1.menuItem.getPrice();
            }
        };
        order.sort(comparator);
        return order.toArray(new MenuItem[0]);
    }

    @Override
    public void showOrder() {
         System.out.print("Order{ ");
         order.forEach(System.out::println);
         System.out.println("\n}");
     }

    @Override
    public String toString() {
        String res = String.valueOf(getNumTable());
        for (NodeOrder nodeOrder : order) {
               res += " " + nodeOrder.menuItem;
        }
        return res;
    }
}

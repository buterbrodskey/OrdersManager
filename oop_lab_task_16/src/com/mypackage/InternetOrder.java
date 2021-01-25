package com.mypackage;

import java.util.*;

public class InternetOrder implements Order{
    Customer customer;
    private class NodeOrder  { //сделал раньше, чем увидел UML
        NodeOrder next;
        NodeOrder prev;
        MenuItem menuItem;
        int quant = 0;


        NodeOrder(MenuItem menuItem) {
            this.menuItem = menuItem;
            quant++;
        }

        String getName() {
            return menuItem.getName();
        }

        String getDescription() {
            return menuItem.getDescription();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeOrder nodeOrder = (NodeOrder) o;
            return Objects.equals(menuItem, nodeOrder.menuItem);
        }

        @Override
        public int hashCode() {
            return Objects.hash(menuItem);
        }

        @Override
        public String toString() {
            return "NodeOrder {" +
                    ", item=" + menuItem +
                    " quant = " + quant +
                    '}';
        }
    }

    NodeOrder Head;

    NodeOrder Temp;

    InternetOrder() {
        Head = new NodeOrder(null);
    }

    InternetOrder(MenuItem[] menuItems) {
        NodeOrder TempHelp = null;

        for (int i = 0; i < menuItems.length; i++) {
            if (Head == null) {
                Head = new NodeOrder(menuItems[i]);
                Temp = Head;
                continue;
            }
            if (Temp.next == null) {
                Temp.next = new NodeOrder(menuItems[i]);
                TempHelp = Temp;
                Temp = Temp.next;
                Temp.prev = TempHelp;
            }
        }
        Head.prev = Temp;
        Temp.next = Head;
    }

    NodeOrder findItem(String name) {
        Temp = Head;

        if (Head == null) { return null;}

        if (Head.next == null && Head.menuItem.getName() !=name) {
            return null;
        }
        do {
            if (name.equals(Temp.menuItem.getName())) {
                return Temp;
            }
            Temp = Temp.next;
        } while (Temp!=Head);
        return null;
    }

    NodeOrder findItem(String name, String descr) {
        Temp = Head;

        if (Head == null) { return null;}

        if (Head.next == null && Head.menuItem.getName() !=name) {
            return null;
        }
        do {
            if (name.equals(Temp.menuItem.getName()) && Temp.menuItem.getDescription().equals(descr)) {
                return Temp;
            }
            Temp = Temp.next;
        } while (Temp!=Head);
        return null;
    }

    public boolean addItem(MenuItem menuItem) {
        if (Head == null) {
            Head = new NodeOrder(menuItem);
            return true;
        }
        else if (Head.next == null) {
            Head.next = new NodeOrder(menuItem);
            Head.prev = Head.next;
            return true;
        }
        else if (findItem(menuItem.getName(), menuItem.getDescription())!=null) {
            findItem(menuItem.getName(), menuItem.getDescription()).quant++;
            return true;
        }
        else {
            Temp = Head.next;
            Head.next = new NodeOrder(menuItem);
            Temp.prev = Head.next;
            Head.next.prev = Head;
            Head.next.next = Temp;
            return true;
        }
    }


    public boolean removeOneItem(String name) {
        Temp = Head;

        if (Head == null) { return false;}

        if (Head.next == null) {
            Head = null;
            return true;
        }
//        do {
            Temp = findItem(name);
            if (name.equals(Temp.menuItem.getName())) {
                Temp.prev.next = Temp.next;
                Temp.next.prev = Temp.prev;
                if (Temp == Head) {
                    Head = Temp.prev;
                }
                return true;
            }
//            Temp = Temp.next;
//        } while (Temp!=Head);
        return false;
    }

    public int removeItem(String name) {
        Temp = Head;
        int counter = 0;
        if (Head == null) { return 0;}

        if (Head.next == null) {
            Head = null;
            return 1;
        }
        do {
            if (name.equals(Temp.menuItem.getName())) {
                Temp.prev.next = Temp.next;
                Temp.next.prev = Temp.prev;
                if (Temp == Head) {
                    Head = Temp.prev;
                }
                counter+=Temp.quant;
            }
            Temp = Temp.next;
        } while (Temp!=Head);
        return counter;
    }

    public int getSize() {
        Temp = Head;
        int counter = 0;
        if (Head == null) { return 0;}

        if (Head.next == null) {
            Head = null;
            return 1;
        }
        do {
            counter+= Temp.quant;
            Temp = Temp.next;
        } while (Temp!=Head);
        return counter;
    }

    public MenuItem[] toItemArray() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        Temp = Head;
        do {
            menuItems.add(Temp.menuItem);
            Temp = Temp.next;
        } while (Temp!=Head);
        return menuItems.toArray(new MenuItem[0]);
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }


    public int getPrice() {
        Temp = Head;
        int counter = 0;
        if (Head == null) { return 0;}

        if (Head.next == null) {
            Head = null;
            return Head.menuItem.getPrice();
        }
        do {
            counter += Temp.menuItem.getPrice()* Temp.quant;
            Temp = Temp.next;
        } while (Temp!=Head);
        return counter;
    }

    public int getItemCount(String name) {
        if (findItem(name)!=null) {
            return findItem(name).quant;
        }
        return 0;
    }

    @Override
    public String[] itemsNames() {
        Set<String> names = new HashSet<>();
        Temp = Head;
        do {
            names.add(Temp.menuItem.getName());
            Temp = Temp.next;
        } while (Temp!=Head);
        return names.toArray(new String[0]);
    }

    @Override
    public MenuItem[] getItems() {
        ArrayList<MenuItem> menuItemArrayList = new ArrayList<>();
        Temp = Head;
        do {
            menuItemArrayList.add(Temp.menuItem);
            Temp = Temp.next;
        } while (Temp!=Head);
        return menuItemArrayList.toArray(new MenuItem[0]);
    }

    @Override
    public int costTotal() {
        int totalCost = 0;
        Temp = Head;
        do {
            totalCost += Temp.quant*Temp.menuItem.getPrice();
            Temp = Temp.next;
        } while (Temp!=Head);
        return totalCost;
    }

    public MenuItem[] toSortedStringArray() {
        Comparator<MenuItem> comparator = new Comparator<MenuItem>() {
            @Override
            public int compare(MenuItem o1, MenuItem o2) {
                return o2.getPrice() - o1.getPrice();
            }
        };
        Set<MenuItem> menuItems = new TreeSet<>(comparator);
        Temp = Head;
        do {
            menuItems.add(Temp.menuItem);
            Temp = Temp.next;
        } while (Temp!=Head);
        return menuItems.toArray(new MenuItem[0]);
    }

    @Override
    public int itemsQuantity(String name) {
        Temp = Head;
        do {
            if (Temp.getName().equals(name))
                return Temp.quant;
            Temp = Temp.next;
        } while (Temp!=Head);
        return 0;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        Temp = Head;
        do {
            if (Temp.menuItem.equals(item))
                return Temp.quant;
            Temp = Temp.next;
        } while (Temp!=Head);
        return 0;
    }

    @Override
    public void showOrder() {
        System.out.println("InternetOrder {");
        Temp = Head;
        do {
            System.out.println("prev = " +Temp.prev.getName() + " curr = " + Temp.getName() + " next = " + Temp.next.getName() + " quant = " + Temp.quant);
            Temp = Temp.next;
        } while (Temp!=Head);

        System.out.println("}");
    }

    @Override
    public String toString() {
        return "InternetOrder{" +
                "Head= " + Head +
                '}';
    }
}

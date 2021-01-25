package com.mypackage;

import java.util.Objects;

public final class Dish implements MenuItem {
    private final int price;
    private final String name;
    private final String description;

    public Dish(int price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "\n\tDish{ " +
                "price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                "}   ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return name.equals(dish.name) &&
                description.equals(dish.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}

package com.mypackage;

import java.util.Objects;

public final class Drink implements MenuItem, Alcoholable {
    private final int price;
    private final String name;
    private final String description;
    private double AlcoholicVol;
    private final DrinkTypeEnum type;

    public Drink(DrinkTypeEnum type, int price, String name, String description) {
        if ((price < 0)|| name.equals("")|| description.equals("")) {
            throw new IllegalTableNumber("Table is not available!");
        }
        this.price = price;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    DrinkTypeEnum getType() {
        return type;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return name.equals(drink.name) &&
                description.equals(drink.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "\n\tDrink{ " +
                "price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                "}   ";
    }

    @Override
    public boolean isAlcoholicDrink() {
        return AlcoholicVol == 0.0d ? false : true;
    }

    @Override
    public double getAlcoholVol() {
        return AlcoholicVol;
    }
}

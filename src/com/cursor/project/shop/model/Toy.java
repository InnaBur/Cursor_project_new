package com.cursor.project.shop.model;

public class Toy extends Product {
    public Toy() {
        super();
    }

    @Override
    public String toString() {
        return " Toy and price: {" +
                "name='" + name + '\'' +
                ", price=" + price + " UAN" +
                '}';
    }
}

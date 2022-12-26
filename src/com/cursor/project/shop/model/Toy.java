package com.cursor.project.shop.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

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

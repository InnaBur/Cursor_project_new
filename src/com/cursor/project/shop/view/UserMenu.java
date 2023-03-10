package com.cursor.project.shop.view;

import com.cursor.project.shop.exceptions.UserIsBlocked;
import com.cursor.project.shop.model.*;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UserMenu {

    /**
     * In the method user can make his choise: register, login,
     * find user by id or exit
     *
     * @param user       class for user
     * @param toysData   the map with toys name and price
     * @param order      the map with order data
     * @param usersOrder the map with users order data
     */
    public void addUserMenu(User user, Map<String, String> toysData,
                            Map<String, String> order, Map<String, Map<String, String>> usersOrder) throws UserIsBlocked {
        int num;
        Scanner scanner = new Scanner(System.in);
        user.showMenu(user);

        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Toys list: " + toysData.toString());
                    break;
                case 2:
                    System.out.println("Input product name: ");
                    Scanner prName = new Scanner(System.in);
                    String p = prName.nextLine();
                    if ((toysData.containsKey(p))) {
                        System.out.println("Found! The price is: " + toysData.get(p));
                    } else {
                        System.out.println("There isn`t this product in our shop!");
                    }
                    break;
                case 3:
                    System.out.println("What do you want? \n" + toysData.toString() + "\n Input product name: ");
                    Scanner prod = new Scanner(System.in);
                    String pr = prod.nextLine();

                    if ((toysData.containsKey(pr))) {
                        System.out.println(pr + " added");
                        order.put(pr, toysData.get(pr));
                        usersOrder.put(user.getNickname(), order);
                        System.out.println(user.getNickname() + " Your order is: " + order);
                        System.out.println("Map order " + usersOrder);
                    } else {
                        System.out.println("There isn`t this product in database!");
                    }
                    break;
                case 4:
                    System.out.println(user.getNickname() + " Your order is: " + order);
                    break;
                case 9:
                    break;
            }
            user.showMenu(user);
        }
    }
}

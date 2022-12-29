package com.cursor.project.shop.service;

import com.cursor.project.shop.exceptions.UserIsBlocked;
import com.cursor.project.shop.exceptions.UserNameOrPasswIsWrong;
import com.cursor.project.shop.model.Admin;
import com.cursor.project.shop.model.Product;
import com.cursor.project.shop.model.Toy;
import com.cursor.project.shop.model.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class AdminService {
    Toy toy = new Toy();
    Product product = new Product();
    Admin admin = new Admin();
    User user = new User();

    public void login() throws UserNameOrPasswIsWrong, UserIsBlocked {

        System.out.println("Input admin nickname: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Input admin password: ");
        Scanner pas = new Scanner(System.in);
        String passw = pas.nextLine();

        if ((admin.getNickname().equals(name)) && (admin.getPassword().equals(passw))) {
            System.out.println(admin.getNickname() + " Admin! You are logging! Congrats!");
        } else {
            throw new UserNameOrPasswIsWrong("Wrong nickname or password!");
        }

    }

    public void addToy(Map<String, String> toysData) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            Scanner productData = new Scanner(System.in);
            System.out.println("Input product name: ");
            String t = productData.nextLine();
            toy.setName(t);

            //   case (2):
            Scanner productPrice = new Scanner(System.in);
            System.out.println("Input product price: ");
            String p = productPrice.nextLine();
            toy.setPrice(p);

            toysData.put(toy.getName(), toy.getPrice());
            break;
        }

    }

    public void blockUser(Map<String, String> usersDataNick, Map<String, String> blockUsers) {

        Scanner name = new Scanner(System.in);
        System.out.println("Input users nickname to block user: ");
        String n = name.nextLine();

        if ((usersDataNick.containsKey(n))) {
            blockUsers.put(n, usersDataNick.get(n));
            usersDataNick.remove(n);
            System.out.println(n + " is blocked");

        } else {
            System.out.println("There isn`t this user in database!");
        }

    }

    public void unblockUser(Map<String, String> usersDataNick, Map<String, String> blockUsers) {

        Scanner name = new Scanner(System.in);
        System.out.println("Input users nickname to unblock user: ");
        String n = name.nextLine();

        if ((blockUsers.containsKey(n))) {
            usersDataNick.put(n, blockUsers.get(n));

            blockUsers.remove(n);
            System.out.println("Bl " + blockUsers);
            System.out.println("Us " + usersDataNick);
            System.out.println(n + " is unblocked");

        } else {
            System.out.println("There isn`t this user in database!");
        }

    }
}

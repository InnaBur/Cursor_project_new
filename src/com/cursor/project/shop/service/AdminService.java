package com.cursor.project.shop.service;

import com.cursor.project.shop.exceptions.UserNameOrPasswIsWrong;
import com.cursor.project.shop.model.Admin;
import com.cursor.project.shop.model.Toy;

import java.util.Map;
import java.util.Scanner;

/**
 * In the class the admin methods created:
 * login, addToy, block and unblock user
 */
public class AdminService {
    Toy toy = new Toy();
    Admin admin = new Admin();

    /**
     * In the method admin logins with the name and password
     *
     * @throws UserNameOrPasswIsWrong - exception when the admin name or password is wrong
     */
    public void login() throws UserNameOrPasswIsWrong {

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

    /**
     * In the method admin adds the product into a product list
     *
     * @param toysData - list for products
     */
    public void addToy(Map<String, String> toysData) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            Scanner productData = new Scanner(System.in);
            System.out.println("Input product name: ");
            String t = productData.nextLine();
            toy.setName(t);

            Scanner productPrice = new Scanner(System.in);
            System.out.println("Input product price: ");
            String p = productPrice.nextLine();
            toy.setPrice(p);
            toysData.put(toy.getName(), toy.getPrice());
            break;
        }
    }

    /**
     * In the method admin blocks user
     *
     * @param usersDataNick the list of all registered users
     * @param blockUsers    - the list of all users who was blocked
     */
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

    /**
     * In the method admin unblocks user
     *
     * @param usersDataNick the list of all registered users
     * @param blockUsers    - the list of all users who was blocked
     */
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

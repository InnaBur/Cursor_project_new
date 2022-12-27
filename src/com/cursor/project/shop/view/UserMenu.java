package com.cursor.project.shop.view;

import com.cursor.project.shop.model.Admin;
import com.cursor.project.shop.model.Book;
import com.cursor.project.shop.model.Toy;
import com.cursor.project.shop.model.User;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class UserMenu {

    MainMenu mainMenu;
    /**
     * In the method user can make his choise: register, login,
     * find user by id or exit
     *
     * @param usersData     - database for finding by id
     * @param usersDataNick - database for login user
     */
    public void addUserMenu(User user, Toy toy,
                                    Map<String, String> toysData,
                                    Map<String, String> usersDataNick, Map<UUID, User> usersData, Map<String, Boolean> userBool,  Map<String, String> order) throws IOException {
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
                        System.out.println(toysData.entrySet());
                    } else {
                        System.out.println("There isn`t this product in database!");
                    }
                    break;
                case 3:
                    System.out.println(toysData.toString());
                    System.out.println("Input product name: ");
                    Scanner prod = new Scanner(System.in);
                    String pr = prod.nextLine();

                    if ((toysData.containsKey(pr))) {
                        System.out.println(pr + " added");
                        order.put(pr, toysData.get(pr));
                        System.out.println("Your order " + order);
                    } else {
                        System.out.println("There isn`t this product in database!");
                    }
                    break;
                case 4:
                case 5:
                case 9:
                    new MainMenu().showSecondStartMenu();
                    new MainMenu().makeChoice();
                    break;
            }
            user.showMenu(user);
        }
    }
}

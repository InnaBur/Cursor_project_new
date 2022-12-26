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

    /**
     * In the method user can make his choise: register, login,
     * find user by id or exit
     *
     * @param usersData     - database for finding by id
     * @param usersDataNick - database for login user
     */
    public void addUserMenu(User user, Toy toy,
                                    Map<String, String> toysData,
                                    Map<String, String> usersDataNick, Map<UUID, User> usersData, Map<String, Boolean> userBool) throws IOException {
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
                case 3:
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

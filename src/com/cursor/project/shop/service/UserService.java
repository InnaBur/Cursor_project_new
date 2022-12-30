package com.cursor.project.shop.service;

import com.cursor.project.shop.exceptions.UserIsBlocked;
import com.cursor.project.shop.exceptions.UserNameOrPasswIsWrong;
import com.cursor.project.shop.model.Toy;
import com.cursor.project.shop.model.User;
import com.cursor.project.shop.view.UserMenu;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

/**
 * In the class the users methods created:
 * login and addUserIntoCollection
 */
public class UserService {

    /**
     * The method allows user to login
     *
     * @param userMenu      class with users menu
     * @param usersDataNick the map with users data
     * @param user          class
     * @param blockUsers    the map with blocked users data
     * @param toy           the product class
     * @param toysData      the map with toys name and price
     * @param order         the map with order data
     * @param usersOrder    the map with users order data
     * @throws UserNameOrPasswIsWrong - exception when the user`s name or password is wrong
     * @throws UserIsBlocked          - exception when the user is blocked
     * @throws IOException            - exception
     */
    public void login(UserMenu userMenu, Map<String, String> usersDataNick, User user,
                      Map<String, String> blockUsers, Toy toy, Map<String, String> toysData,
                      Map<String, String> order, Map<String,
            Map<String, String>> usersOrder) throws UserNameOrPasswIsWrong, UserIsBlocked, IOException {

        System.out.println("Input your nickname: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Input your password: ");
        Scanner pas = new Scanner(System.in);
        String passw = pas.nextLine();

        if ((usersDataNick.containsKey(name)) && (usersDataNick.containsValue(passw))
                && (!blockUsers.containsKey(name))) {
            System.out.println(name + "! You are logging! Congrats! \n User menu:");
            userMenu.addUserMenu(user, toysData, order, usersOrder);
        } else if (blockUsers.containsKey(name)) {
            throw new UserIsBlocked("You are blocked!");
        } else {
            throw new UserNameOrPasswIsWrong("Wrong nickname or password!");
        }
    }

    public void addUserIntoCollection(User user, Map<UUID, User> usersData,
                                      Map<String, String> usersDataNick, Map<String, Boolean> userBool) {
        usersData.put(user.getId(), user);
        usersDataNick.put(user.getNickname(), user.getPassword());
        System.out.println(user.getName() + "! You are registered!");

    }
}

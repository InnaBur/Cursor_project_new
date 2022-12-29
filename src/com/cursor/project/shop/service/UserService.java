package com.cursor.project.shop.service;

import com.cursor.project.shop.exceptions.UserIsBlocked;
import com.cursor.project.shop.exceptions.UserNameOrPasswIsWrong;
import com.cursor.project.shop.model.Toy;
import com.cursor.project.shop.model.User;
import com.cursor.project.shop.view.UserMenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class UserService {

    public void login(UserMenu userMenu, Map<String, String> usersDataNick, User user,
                      Map<String, String> blockUsers,
                      Toy toy, Map<String, String> toysData, Map<String, String> order, Map<String, Map<String, String>> usersOrder) throws UserNameOrPasswIsWrong, UserIsBlocked, IOException {
        //User user = new User();

        System.out.println("Input your nickname: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Input your password: ");
        Scanner pas = new Scanner(System.in);
        String passw = pas.nextLine();

        if ((usersDataNick.containsKey(name)) && (usersDataNick.containsValue(passw))
                && (!blockUsers.containsKey(name))) {
            System.out.println(name + "! You are logging! Congrats! \n User menu:");
            userMenu.addUserMenu(user, toy, toysData, usersDataNick, order, usersOrder);
        }
            else if (blockUsers.containsKey(name)) {
                throw new UserIsBlocked("You are blocked!");
            } else {
            throw new UserNameOrPasswIsWrong("Wrong nickname or password!");

        }

    }

    public void addUserIntoCollection(User user, Map<UUID, User> usersData,
                                      Map<String, String> usersDataNick, Map<String, Boolean> userBool) {
        //userBool.put(user.getNickname(), user.isBlocked());
        usersData.put(user.getId(), user);
        usersDataNick.put(user.getNickname(), user.getPassword());
        System.out.println(user.getName() + "! You are registered!");

    }


}

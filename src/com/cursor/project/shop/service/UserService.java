package com.cursor.project.shop.service;

import com.cursor.project.shop.exceptions.UserIsBlocked;
import com.cursor.project.shop.exceptions.UserNameOrPasswIsWrong;
import com.cursor.project.shop.model.User;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class UserService {

    public void login(Map<String, String> usersDataNick, User user,
                              Map<UUID, User> usersData, Map<String, Boolean> userBool) throws UserNameOrPasswIsWrong, UserIsBlocked {
        //User user = new User();

        System.out.println("Input your nickname: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Input your password: ");
        Scanner pas = new Scanner(System.in);
        String passw = pas.nextLine();


        if ((usersDataNick.containsKey(name)) && (usersDataNick.containsValue(passw))
                && (userBool.containsValue(false)) && (user != null)) {
            System.out.println(user.getNickname() + " You are logging! Congrats!");
        } else if ((usersDataNick.containsKey(name)) && (usersDataNick.containsValue(passw)) && (user != null)
                && (userBool.containsValue(true))) {
            throw new UserIsBlocked("You are blocked!");
        } else {
            throw new UserNameOrPasswIsWrong("Wrong nickname or password!");

        }

    }

    public void addUserIntoCollection(User user, Map<UUID, User> usersData,
                                       Map<String, String> usersDataNick, Map<String, Boolean> userBool) {
        userBool.put(user.getNickname(), user.isBlocked());
        usersData.put(user.getId(), user);
        usersDataNick.put(user.getNickname(), user.getPassword());
        System.out.println(user.getName() + "! You are registered!");

    }


}

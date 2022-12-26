package com.cursor.project.shop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends People {

    User user = new User();
    @Override
    public String getNickname() {
        return "Inna";
    }

    @Override
    public String getPassword() {
        return "abcd";
    }



    @Override
    public void showMenu(Admin admin) {
        System.out.println(admin.getNickname() + " Make your choice! If you want to add product to the list - press 1 " +
                "\n If you want to block user - press 2 " +
                "\n If you want to unblock user - press 3" +
                "\n If you want to confirm order - press 4" +
                "\n If you want to return into past menu - press 9!");
    }

    @Override
    public void showMenu(User user) {

    }


}

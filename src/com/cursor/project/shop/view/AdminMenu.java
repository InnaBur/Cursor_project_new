package com.cursor.project.shop.view;

import com.cursor.project.shop.model.Admin;
import com.cursor.project.shop.model.Book;
import com.cursor.project.shop.model.Toy;
import com.cursor.project.shop.model.User;
import com.cursor.project.shop.service.AdminService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class AdminMenu {
    AdminService adminService = new AdminService();
    Toy toy;
    Admin admin = new Admin();

    public void addAdminMenu(User user, Map<String, String> toysData, Map<String, String> usersDataNick, Map<String, String> blockUsers, Map<String, Map<String, String>> usersOrder) throws IOException {
        admin.showMenu();
        Scanner scanner = new Scanner(System.in);
        int num;

        while (scanner.hasNextInt()) {
           num = scanner.nextInt();
            switch (num) {
                case 1:
                    adminService.addToy(toysData);
                    System.out.println("Toys data: " + toysData.toString());
                    break;
                case 2:
                    System.out.println(usersDataNick.toString());
                    adminService.blockUser(usersDataNick, blockUsers);
                    System.out.println("Us " + usersDataNick.toString());
                    break;
                case 3:
                    System.out.println("Blocked " + blockUsers.toString());
                    adminService.unblockUser(usersDataNick, blockUsers);
                case 4:
                    System.out.println("Input users name: ");
                    Scanner name = new Scanner(System.in);
                    String n = name.nextLine();
                        if ((usersOrder.containsKey(n))) {
                            System.out.println(n + usersOrder);
                        } else {
                            System.out.println("There isn`t this user in database!");
                        }

                case 6:
                    break;

            }

            admin.showMenu();
        }
    }


}

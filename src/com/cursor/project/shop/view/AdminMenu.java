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
    public void addAdminMenu(User user, Map<String, String> toysData, Map<String, String> usersDataNick, ArrayList<User> blockUsers) throws IOException {
        int num;
        Scanner scanner = new Scanner(System.in);
        admin.showMenu(admin);

        while (true) {
            //num = ;
            switch (scanner.nextInt()) {
                case 1:
                    /* reading txt file with toys database into a map
                     * which will be supplemented with products that will be provided by the admin
                     */
                    adminService.addToy( toysData);
                    System.out.println("Toys data: " + toysData.toString());
                    break;
                case 2:
                    adminService.blockUser(usersDataNick, blockUsers);
                    break;
                case 3:
                case 4:
                case 9:
                    new MainMenu().showSecondStartMenu();
                    new MainMenu().makeChoice();
                    break;
                case 6:
            }
            admin.showMenu(admin);
        }
    }


}

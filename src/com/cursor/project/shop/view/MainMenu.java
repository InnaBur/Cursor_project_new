package com.cursor.project.shop.view;

import com.cursor.project.shop.exceptions.UserIsBlocked;
import com.cursor.project.shop.exceptions.UserNameOrPasswIsWrong;
import com.cursor.project.shop.model.Admin;
import com.cursor.project.shop.model.Book;
import com.cursor.project.shop.model.Toy;
import com.cursor.project.shop.model.User;
import com.cursor.project.shop.service.AdminService;
import com.cursor.project.shop.service.UserService;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MainMenu {
    Admin admin = new Admin();
    Toy toy ;
    Book book = new Book();
    UserService userService = new UserService();
    UserMenu userMenu =new UserMenu();
    AdminService adminService = new AdminService();
    AdminMenu adminMenu = new AdminMenu();
    User user = new User();


    //map for users data
    Map<UUID, User> usersData = new HashMap<>();
    Map<String, String> usersDataNick = new HashMap<>();
    Map<String, Boolean> userBool = new HashMap<>();

    // map for the products with prices
    Map<String, Integer> productsData = new HashMap<>();
    Map<String, String> toysData = new HashMap<>();
    Map<String, String> booksData = new HashMap<>();
    Map<String, String> order = new HashMap<>();
ArrayList<User> blockUsers = new ArrayList<>();
    public void makeChoice() throws IOException {
        // reading data about products from the txt files
        readFileToysData(toysData, booksData, "file/Toys.txt");
        showStartMenu();
        Scanner scanner = new Scanner(System.in);
        int num;
       // user = null;

        while (scanner.hasNextInt()) {

            num = scanner.nextInt();

            switch (num) {
                case 1:
                    user.addUser();

                    if (!usersDataNick.containsKey(user.getNickname())) {
                        userService.addUserIntoCollection(user, usersData, usersDataNick, userBool);
                        for (Map.Entry entry : usersDataNick.entrySet())
                        {
                            System.out.println("key: " + entry.getKey().toString() + "; value: " + entry.getValue().toString());
                        }

                        break;

                    } else {
                        System.out.println("User is already exist! Try once more!");
                        break;
                    }

                case 2:
                    try {
                       userService.login(usersDataNick, user, usersData, userBool);
                        System.out.println("User menu!");
                        userMenu.addUserMenu(user, toy, toysData, usersDataNick, usersData, userBool, order);

                        break;
                    } catch (UserNameOrPasswIsWrong e) {
                        System.out.println("" + e.getMessage());
                        break;
                    }
                    catch (UserIsBlocked e) {
                        System.out.println(" " + e.getMessage());
                    }
                case 3:
                    try {
                        adminService.login();
                        adminMenu.addAdminMenu(user, toysData, usersDataNick, blockUsers);
                        break;
                    } catch (UserNameOrPasswIsWrong e) {
                        System.out.println("" + e.getMessage());
                        break;
                    } catch (UserIsBlocked ex) {
                        System.out.println("Blocked " + ex.getMessage());
                        break;
                    }
                case 4:
                    System.exit(0);
                case 5:
                    System.out.println("Incorrect choice! Good luck next time you run the program");
                    System.exit(0);
            }
            new MainMenu().showSecondStartMenu();
        }
    }
    public void showStartMenu() {
        System.out.println("Hi, there! Welcome to the toy store! \n Make your choice! If you want to register new user press 1 " +
                "\n If you want to login - press 2 " +
                "\n If you want to login as admin - press 3!" +
                "\n If you want to exit - press 4!");
    }
    public void showSecondStartMenu() {
        System.out.println("Make your choice! If you want to register new user press 1 " +
                "\n If you want to login - press 2 " +
                "\n If you want to login as admin - press 3!" +
                "\n If you want to exit - press 4!");
    }
    /**
     * In the method we read file with the name and the price of product (toy)
     * @param toysData  into this collection data from the toys file is reading
     * @param booksData - into this collection data from the books file is reading
     * @param filename - the name of the file you need
     */
    private static void readFileToysData(Map<String, String> toysData, Map<String, String> booksData, String filename) {
        String line;
        // adding the words and digits into array
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                String name = words[0]; // the name
                String price = words[1];
                if (filename.equals("file/Toys.txt")) {
                    toysData.put(name, price);
                } else if (filename.equals("file/Books.txt")) {
                    booksData.put(name, price);
                }

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(("File is not found " + e.getMessage()));
        } catch (IOException e) {
            System.out.println(("Something went wrong " + e.getMessage()));
        }
    }
}

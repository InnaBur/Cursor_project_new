package com.cursor.project.shop.model;

public class Admin extends People {

    @Override
    public String getNickname() {
        return "Inna";
    }

    @Override
    public String getPassword() {
        return "abcd";
    }

    @Override
    public void showMenu(User user) {
    }

    @Override
    public void showMenu(Admin admin) {
        System.out.println(this.getNickname() + " Make your choice! \n If you want to add product to the list - press 1 (twice)" +
                "\n If you want to block user - press 2 " +
                "\n If you want to unblock user - press 3" +
                "\n If you want to confirm order - press 4" +
                "\n If you want to return into past menu - press 'a'!");
    }
}

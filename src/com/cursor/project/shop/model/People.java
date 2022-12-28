package com.cursor.project.shop.model;

public abstract class People {

    private String name;
    private String lastName;
    private String nickname;
    private String password;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }


    public abstract void showMenu();


}

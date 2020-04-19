package com.example.bit603_assignment2_jasonnorton_5001428;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class User {

    private int id;
    private String username;
    private String password;
    private String favouriteColour;
    private static String[][] userArray = new String[][] {{"Jason", "Sword", "Red"},{"Billy", "Dinosaur", "Blue"},{"Zack", "Elephant", "Black"},{"Trini", "Tiger", "Yellow"},{"Kimberly", "Bird", "Pink"}};
    private static List<User> userList = new ArrayList<User>();
    private static String activeUser = "";

    private User(String username, String password, String favouriteColour) {
        this.id = id++;
        this.username = username;
        this.password = password;
        this.favouriteColour = favouriteColour;
    }

    public static void setUsers() {
        for (int i = 0; i < userArray.length; i++) {
            // User user = new User(userArray[i][0], userArray[i][1], userArray[i][2]);

            userList.add(new User(userArray[i][0], userArray[i][1], userArray[i][2]));
        }
    }

    public static Boolean credentialsVerified (String username, String password) {
        for(User user : userList) {
            user.getUsername();
            user.getPassword();
            user.getFavouriteColour();
            if(username.equals(user.getUsername())) {
                activeUser = user.getUsername();
                if(password.equals(user.getPassword())) {
                    return true;
                }
            }
        }
    return false;
    }

    // Getters and Setters:

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

}// End User Class

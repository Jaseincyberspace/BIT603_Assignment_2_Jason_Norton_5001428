package com.example.bit603_assignment2_jasonnorton_5001428;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String username;
    private String password;
    private String favouriteColour;
    private static String[][] userArray = new String[][] {{"Jason", "Sword", "Red"},{"Billy", "Dinosaur", "Blue"},{"Zack", "Elephant", "Black"},{"Trini", "Tiger", "Yellow"},{"Kimberly", "Bird", "Pink"}};
    private static List<User> userList = new ArrayList<>();
    // ActiveUser String array contains: id, Username, Password, favouriteColour - in that order.
    private static String[] activeUser = new String[4];

    private User(String username, String password, String favouriteColour) {
        this.id = id++;
        this.username = username;
        this.password = password;
        this.favouriteColour = favouriteColour;
    }

    static Boolean credentialsVerified (String username, String password) {
        for(User user : userList) {
            if(username.equals(user.getUsername())) {
                activeUser[0] = Integer.toString(user.getID());
                activeUser[1] = user.getUsername();
                activeUser[2] =  user.getPassword();
                activeUser[3] = user.getFavouriteColour();

                if(password.equals(user.getPassword())) {

                    return true;
                }
            }
        }
    return false;
    }

    static Boolean securityQuestionCorrect (String username, String favouriteColour) {
        for(User user : userList) {
            if(username.equals(user.getUsername()) && favouriteColour.equals(user.getFavouriteColour())) {
                activeUser[0] = Integer.toString(user.getID());
                activeUser[1] = user.getUsername();
                activeUser[2] =  user.getPassword();
                activeUser[3] = user.getFavouriteColour();
                return true;
            }
        }
        return false;
    }

    // Getters and Setters:

    static void setUserArray(String newPassword) {
        for(String[] user : userArray) {
            if(activeUser[1].equals(user[0])) {
                user[1] = newPassword;
            }
        }

    }

    static void setUsers() {
        for (int i = 0; i < userArray.length; i++) {
            userList.add(new User(userArray[i][0], userArray[i][1], userArray[i][2]));
        }
    }

    static String[] getActiveUser() {
        return activeUser;
    }

    public int getID() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

}// End User Class

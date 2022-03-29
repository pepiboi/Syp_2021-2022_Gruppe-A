package com.login_signup_screendesign_demo;

import java.util.ArrayList;
import java.util.List;

public class UserSignups {
    private static List<UserData> userSignupsList;

    public UserSignups() {
        userSignupsList = new ArrayList<>();
    }

    public static void addUser(UserData userData){
        userSignupsList.add(userData);
    }

    public static boolean isAccount(String emailId, String password){
        for(UserData userData:userSignupsList){
            if(userData.getEmailId().equals(emailId) && userData.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public List<UserData> getUserSignupsList() {
        return userSignupsList;
    }

    public static boolean isAdmin(String emailId, String password){
        for(UserData userData:userSignupsList){
            if(userData.getEmailId().equals(emailId) && userData.getPassword().equals(password) && userData.isAdmin()){
                return true;
            }
        }
        return false;
    }

    public static void setAdmin(String emailId){
        for(UserData userData:userSignupsList){
            if(userData.getEmailId().equals(emailId)){
                userData.setAdmin(true);
            }
        }
    }

    public static boolean emailExists(String email){
        for(UserData userData:userSignupsList){
            if(userData.getEmailId().equals(email)){
                return true;
            }
        }
        return false;
    }
}
